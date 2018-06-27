package com.alloiz.alloizserver.controller;

import com.alloiz.alloizserver.model.Technologies;
import com.alloiz.alloizserver.service.TechnologiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/technologies")
public class TechnologiesController {

    @Autowired
    private TechnologiesService technologiesService;

    @GetMapping("/find-all")
    private ResponseEntity<List<Technologies>> findAll() {
        return ResponseEntity.ok(technologiesService.findAll());
    }

    @GetMapping("/find-all-available")
    private ResponseEntity<List<Technologies>> findAllAvailable() {
        return ResponseEntity.ok(technologiesService.findAllAvailable());
    }

    @GetMapping("/find-one-available/{id}")
    private ResponseEntity<Technologies> findOneAvailale(@PathVariable Long id) {
        return ResponseEntity.ok(technologiesService.findOneAvailable(id));
    }


    @GetMapping("/find-one/{id}")
    private ResponseEntity<Technologies> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(technologiesService.findOne(id));
    }


    @PostMapping("/save")
    private ResponseEntity<Technologies> save(@RequestBody Technologies technologies) {
        return ResponseEntity.ok(technologiesService.save(technologies));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity delete(@PathVariable Long id) {
        return ResponseEntity.status(technologiesService.delete(id) ? HttpStatus.OK : HttpStatus.CONFLICT).build();
    }

}
