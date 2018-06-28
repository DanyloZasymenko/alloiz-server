package com.alloiz.alloizserver.controller;

import static com.alloiz.alloizserver.dto.utils.builder.Builder.map;

import com.alloiz.alloizserver.dto.PortfolioDescriptionDto;
import com.alloiz.alloizserver.model.PortfolioDescription;
import com.alloiz.alloizserver.service.PortfolioDescriptionService;
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
@RequestMapping("/portfolio-description")
public class PortfolioDescriptionController {

  @Autowired
  PortfolioDescriptionService portfolioDescriptionService;

  @GetMapping("/find-all")
  private ResponseEntity<List<PortfolioDescriptionDto>> findAll(){
    return ResponseEntity.ok(portfolioDescriptionService.findAll().stream()
        .map(image -> map(image,PortfolioDescriptionDto.class)).collect(Collectors.toList()));
  }

  @GetMapping("/find-all-available")
  private ResponseEntity<List<PortfolioDescriptionDto>> findAllAvailable(){
    return ResponseEntity.ok(portfolioDescriptionService.findAllAvailable().stream()
        .map(image -> map(image,PortfolioDescriptionDto.class)).collect(Collectors.toList()));
  }

  @GetMapping("/find-one-available/{id}")
  private ResponseEntity<PortfolioDescriptionDto> findOneAvailale(@PathVariable Long id){
    return ResponseEntity.ok(map(portfolioDescriptionService.findOneAvailable(id),PortfolioDescriptionDto.class));
  }


  @GetMapping("/find-one/{id}")
  private ResponseEntity<PortfolioDescriptionDto> findOne(@PathVariable Long id){
    return ResponseEntity.ok(map(portfolioDescriptionService.findOne(id),PortfolioDescriptionDto.class));
  }


  @PostMapping("/save")
  private ResponseEntity<PortfolioDescriptionDto> save(@RequestBody PortfolioDescriptionDto portfolioDescriptionDto) {
    return ResponseEntity.ok(map(portfolioDescriptionService.save(map(portfolioDescriptionDto, PortfolioDescription.class)), PortfolioDescriptionDto.class));
  }

  @DeleteMapping("/delete/{id}")
  private ResponseEntity delete(@PathVariable Long id){
    return new ResponseEntity(map(portfolioDescriptionService.delete(id) ? HttpStatus.OK:HttpStatus.CONFLICT));
  }

  @PostMapping("/update")
  private ResponseEntity<PortfolioDescriptionDto> update(@RequestBody PortfolioDescriptionDto PortfolioDto) {
    return ResponseEntity.ok(map(portfolioDescriptionService.update(map(PortfolioDto, PortfolioDescription.class)), PortfolioDescriptionDto.class));
  }

}
