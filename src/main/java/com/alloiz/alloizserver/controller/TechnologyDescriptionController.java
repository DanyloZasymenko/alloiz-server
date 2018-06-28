package com.alloiz.alloizserver.controller;

import com.alloiz.alloizserver.dto.TechnologyDescriptionDto;
import com.alloiz.alloizserver.model.TechnologyDescription;
import com.alloiz.alloizserver.service.TechnologyDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.alloiz.alloizserver.dto.utils.builder.Builder.map;

@RestController
@RequestMapping("/technology-description")
public class TechnologyDescriptionController {

    @Autowired
    private TechnologyDescriptionService technologyDescriptionService;

    @GetMapping("/find-all")
    private ResponseEntity<List<TechnologyDescriptionDto>> findAll() {
        return ResponseEntity.ok(technologyDescriptionService.findAll().stream()
                .map(image -> map(image, TechnologyDescriptionDto.class)).collect(Collectors.toList()));
    }

    @GetMapping("/find-all-available")
    private ResponseEntity<List<TechnologyDescriptionDto>> findAllAvailable() {
        return ResponseEntity.ok(technologyDescriptionService.findAllAvailable().stream()
                .map(image -> map(image, TechnologyDescriptionDto.class)).collect(Collectors.toList()));
    }

    @GetMapping("/find-one-available/{id}")
    private ResponseEntity<TechnologyDescriptionDto> findOneAvailale(@PathVariable Long id) {
        return ResponseEntity.ok(map(technologyDescriptionService.findOneAvailable(id), TechnologyDescriptionDto.class));
    }


    @GetMapping("/find-one/{id}")
    private ResponseEntity<TechnologyDescriptionDto> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(map(technologyDescriptionService.findOne(id), TechnologyDescriptionDto.class));
    }


    @PostMapping("/save")
    private ResponseEntity<TechnologyDescriptionDto> save(@RequestBody TechnologyDescriptionDto technologyDescription) {
        return ResponseEntity.ok(map(technologyDescriptionService.save(map(technologyDescription, TechnologyDescription.class)), TechnologyDescriptionDto.class));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity delete(@PathVariable Long id) {
        return new ResponseEntity(map(technologyDescriptionService.delete(id) ? HttpStatus.OK : HttpStatus.CONFLICT));
    }

    @PostMapping("/update")
    private ResponseEntity<TechnologyDescriptionDto> update(@RequestBody TechnologyDescriptionDto technologyDescription) {
        return ResponseEntity.ok(map(technologyDescriptionService.update(map(technologyDescription, TechnologyDescription.class)), TechnologyDescriptionDto.class));
    }
}
