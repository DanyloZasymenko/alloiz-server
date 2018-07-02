package com.alloiz.alloizserver.controller;

import com.alloiz.alloizserver.dto.PortfolioDto;
import com.alloiz.alloizserver.model.Portfolio;
import com.alloiz.alloizserver.service.PortfolioService;
import com.alloiz.alloizserver.service.impl.PortfolioServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

import static com.alloiz.alloizserver.dto.utils.builder.Builder.map;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {
    private static final Logger LOGGER = Logger.getLogger(PortfolioController.class);


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
    private ResponseEntity<PortfolioDto> save(@RequestParam String portfolioJson,
                                              @RequestParam(required = false) MultipartFile [] multipartFiles) {
        return ResponseEntity.ok(map(portfolioService.save(portfolioJson, multipartFiles), PortfolioDto.class));
    }

    @PostMapping("/update")
    private ResponseEntity<PortfolioDto> update(@RequestParam String portfolioJson) {
        return ResponseEntity.ok(map(portfolioService.update(portfolioJson), PortfolioDto.class));
    }

    @PostMapping("/update-image/{id}")
    private ResponseEntity<PortfolioDto> updateImage(@RequestParam MultipartFile [] multipartFile, @PathVariable Long id) {
        return ResponseEntity.ok(map(portfolioService.updateImage(multipartFile, id), PortfolioDto.class));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity delete(@PathVariable Long id) {
        return ResponseEntity.ok(portfolioService.deleteById(id));
    }

}
