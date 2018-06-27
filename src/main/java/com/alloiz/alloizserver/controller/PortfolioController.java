package com.alloiz.alloizserver.controller;

import com.alloiz.alloizserver.model.Portfolio;
import com.alloiz.alloizserver.service.PortfolioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

  @Autowired
  private PortfolioService portfolioService;

  @GetMapping("/find-all")
  private ResponseEntity<List<Portfolio>> findAll() {
    return ResponseEntity.ok(portfolioService.findAll());
  }

  @GetMapping("/find-all-available")
  private ResponseEntity<List<Portfolio>> findAllAvailable() {
    return ResponseEntity.ok(portfolioService.findAllAvailable());
  }

  @GetMapping("/find-one-available/{id}")
  private ResponseEntity<Portfolio> findOneAvailale(@PathVariable Long id) {
    return ResponseEntity.ok(portfolioService.findOneAvailable(id));
  }

  @GetMapping("/find-one/{id}")
  private ResponseEntity<Portfolio> findOne(@PathVariable Long id) {
    return ResponseEntity.ok(portfolioService.findOne(id));
  }

  @PostMapping("/save")
  private ResponseEntity<Portfolio> save(@RequestBody Portfolio portfolio) {
    return ResponseEntity.ok(portfolioService.save(portfolio));
  }

  @DeleteMapping("/delete/{id}")
  private ResponseEntity delete(@PathVariable Long id) {
    return ResponseEntity
        .status(portfolioService.deleteById(id) ? HttpStatus.OK : HttpStatus.CONFLICT).build();
  }

}
