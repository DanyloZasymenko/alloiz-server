package com.alloiz.alloizserver.controller;

import com.alloiz.alloizserver.dto.PortfolioDto;
import com.alloiz.alloizserver.model.Portfolio;
import com.alloiz.alloizserver.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.alloiz.alloizserver.dto.utils.builder.Builder.map;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("/find-all")
    private ResponseEntity<List<PortfolioDto>> findAll() {
        return ResponseEntity.ok(portfolioService.findAll().stream()
                .map(callback -> map(callback, PortfolioDto.class)).collect(Collectors.toList()));
    }

    @GetMapping("/find-all-available")
    private ResponseEntity<List<PortfolioDto>> findAllAvailable() {
        return ResponseEntity.ok(portfolioService.findAllAvailable().stream()
                .map(callback -> map(callback, PortfolioDto.class)).collect(Collectors.toList()));
    }

    @GetMapping("/find-one-available/{id}")
    private ResponseEntity<PortfolioDto> findOneAvailale(@PathVariable Long id) {
        return ResponseEntity.ok(map(portfolioService.findOneAvailable(id), PortfolioDto.class));
    }


    @GetMapping("/find-one/{id}")
    private ResponseEntity<PortfolioDto> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(map(portfolioService.findOne(id), PortfolioDto.class));
    }


    @PostMapping("/save")
    private ResponseEntity<PortfolioDto> save(@RequestBody PortfolioDto portfolio) {
        return ResponseEntity.ok(map(portfolioService.save(map(portfolio, Portfolio.class)), PortfolioDto.class));
    }

    @PostMapping("/update")
    private ResponseEntity<PortfolioDto> update(@RequestBody PortfolioDto portfolio) {
        return ResponseEntity.ok(map(portfolioService.update(map(portfolio, Portfolio.class)), PortfolioDto.class));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity delete(@PathVariable Long id) {
        return new ResponseEntity(map(portfolioService.deleteById(id) ? HttpStatus.OK : HttpStatus.CONFLICT));
    }

}
