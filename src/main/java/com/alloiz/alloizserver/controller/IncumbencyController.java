package com.alloiz.alloizserver.controller;

import com.alloiz.alloizserver.model.Incumbency;
import com.alloiz.alloizserver.service.IncumbencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incumbency")
public class IncumbencyController {

    @Autowired
    private IncumbencyService incumbencyService;

    @GetMapping("/find-all")
    private ResponseEntity<List<Incumbency>> findAll() {
        return ResponseEntity.ok(incumbencyService.findAll());
    }

    @GetMapping("/find-all-available")
    private ResponseEntity<List<Incumbency>> findAllAvailable() {
        return ResponseEntity.ok(incumbencyService.findAllAvailable());
    }

    @GetMapping("/find-one-available/{id}")
    private ResponseEntity<Incumbency> findOneAvailale(@PathVariable Long id) {
        return ResponseEntity.ok(incumbencyService.findOneAvailable(id));
    }


    @GetMapping("/find-one/{id}")
    private ResponseEntity<Incumbency> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(incumbencyService.findOne(id));
    }


    @PostMapping("/save")
    private ResponseEntity<Incumbency> save(@RequestBody Incumbency incumbency) {
        return ResponseEntity.ok(incumbencyService.save(incumbency));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity delete(@PathVariable Long id) {
        return ResponseEntity.status(incumbencyService.delete(id) ? HttpStatus.OK : HttpStatus.CONFLICT).build();
    }
}
