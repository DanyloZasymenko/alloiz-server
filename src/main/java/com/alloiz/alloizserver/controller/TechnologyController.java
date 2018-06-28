package com.alloiz.alloizserver.controller;

import com.alloiz.alloizserver.dto.TechnologyDto;
import com.alloiz.alloizserver.model.Technology;
import com.alloiz.alloizserver.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.alloiz.alloizserver.dto.utils.builder.Builder.map;

@RestController
@RequestMapping("/technology")
public class TechnologyController {

    @Autowired
    private TechnologyService technologyService;

    @GetMapping("/find-all")
    private ResponseEntity<List<TechnologyDto>> findAll(){
        return ResponseEntity.ok(technologyService.findAll().stream()
                .map(callback -> map(callback,TechnologyDto.class)).collect(Collectors.toList()));
    }

    @GetMapping("/find-all-available")
    private ResponseEntity<List<TechnologyDto>> findAllAvailable(){
        return ResponseEntity.ok(technologyService.findAllAvailable().stream()
                .map(callback -> map(callback,TechnologyDto.class)).collect(Collectors.toList()));
    }

    @GetMapping("/find-one-available/{id}")
    private ResponseEntity<TechnologyDto> findOneAvailale(@PathVariable Long id){
        return ResponseEntity.ok(map(technologyService.findOneAvailable(id),TechnologyDto.class));
    }


    @GetMapping("/find-one/{id}")
    private ResponseEntity<TechnologyDto> findOne(@PathVariable Long id){
        return ResponseEntity.ok(map(technologyService.findOne(id),TechnologyDto.class));
    }


    @PostMapping("/save")
    private ResponseEntity<TechnologyDto> save(@RequestBody TechnologyDto TechnologyDto) {
        return ResponseEntity.ok(map(technologyService.save(map(TechnologyDto, Technology.class)), TechnologyDto.class));
    }

    @PostMapping("/update")
    private ResponseEntity<TechnologyDto> update(@RequestBody TechnologyDto TechnologyDto) {
        return ResponseEntity.ok(map(technologyService.update(map(TechnologyDto, Technology.class)), TechnologyDto.class));
    }


    @DeleteMapping("/delete/{id}")
    private ResponseEntity delete(@PathVariable Long id){
        return new ResponseEntity(map(technologyService.delete(id) ? HttpStatus.OK:HttpStatus.CONFLICT));
    }
}
