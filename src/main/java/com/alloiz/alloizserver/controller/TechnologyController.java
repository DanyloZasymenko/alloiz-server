package com.alloiz.alloizserver.controller;

import com.alloiz.alloizserver.model.Technology;
import com.alloiz.alloizserver.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/technology")
public class TechnologyController {

    @Autowired
    private TechnologyService technologyService;

    @GetMapping("/find-all")
    private ResponseEntity<List<Technology>> findAll() {
        return ResponseEntity.ok(technologyService.findAll());
    }

    @GetMapping("/find-all-available")
    private ResponseEntity<List<Technology>> findAllAvailable() {
        return ResponseEntity.ok(technologyService.findAllAvailable());
    }

    @GetMapping("/find-one-available/{id}")
    private ResponseEntity<Technology> findOneAvailale(@PathVariable Long id) {
        return ResponseEntity.ok(technologyService.findOneAvailable(id));
    }


    @GetMapping("/find-one/{id}")
    private ResponseEntity<Technology> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(technologyService.findOne(id));
    }


    @PostMapping("/save")
    private ResponseEntity<Technology> save(@RequestBody Technology technologies) {
        return ResponseEntity.ok(technologyService.save(technologies));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity delete(@PathVariable Long id) {
        return ResponseEntity.status(technologyService.delete(id) ? HttpStatus.OK : HttpStatus.CONFLICT).build();
    }

}
