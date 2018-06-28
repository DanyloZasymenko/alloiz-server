package com.alloiz.alloizserver.controller;

import static com.alloiz.alloizserver.dto.utils.builder.Builder.map;

import com.alloiz.alloizserver.dto.TechnologyDescriptionDto;
import com.alloiz.alloizserver.model.TechnologyDescription;
import com.alloiz.alloizserver.service.TechnologyDescriptionService;
import java.util.List;
import java.util.stream.Collectors;
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
@RequestMapping("/technology-description")
public class TechnologyDescriptionController {

  @Autowired
  private TechnologyDescriptionService technologyDescriptionService;

  @GetMapping("/find-all")
  private ResponseEntity<List<TechnologyDescriptionDto>> findAll(){
    return ResponseEntity.ok(technologyDescriptionService.findAll().stream()
        .map(image -> map(image,TechnologyDescriptionDto.class)).collect(Collectors.toList()));
  }

  @GetMapping("/find-all-available")
  private ResponseEntity<List<TechnologyDescriptionDto>> findAllAvailable(){
    return ResponseEntity.ok(technologyDescriptionService.findAllAvailable().stream()
        .map(image -> map(image,TechnologyDescriptionDto.class)).collect(Collectors.toList()));
  }

  @GetMapping("/find-one-available/{id}")
  private ResponseEntity<TechnologyDescriptionDto> findOneAvailale(@PathVariable Long id){
    return ResponseEntity.ok(map(technologyDescriptionService.findOneAvailable(id),TechnologyDescriptionDto.class));
  }


  @GetMapping("/find-one/{id}")
  private ResponseEntity<TechnologyDescriptionDto> findOne(@PathVariable Long id){
    return ResponseEntity.ok(map(technologyDescriptionService.findOne(id),TechnologyDescriptionDto.class));
  }


  @PostMapping("/save")
  private ResponseEntity<TechnologyDescriptionDto> save(@RequestBody TechnologyDescriptionDto technologyDescriptionDto) {
    return ResponseEntity.ok(map(technologyDescriptionService.save(map(technologyDescriptionDto, TechnologyDescription.class)), TechnologyDescriptionDto.class));
  }

  @DeleteMapping("/delete/{id}")
  private ResponseEntity delete(@PathVariable Long id){
    return new ResponseEntity(map(technologyDescriptionService.delete(id) ? HttpStatus.OK:HttpStatus.CONFLICT));
  }

  @PostMapping("/update")
  private ResponseEntity<TechnologyDescriptionDto> update(@RequestBody TechnologyDescriptionDto PortfolioDto) {
    return ResponseEntity.ok(map(technologyDescriptionService.update(map(PortfolioDto, TechnologyDescription.class)), TechnologyDescriptionDto.class));
  }
}
