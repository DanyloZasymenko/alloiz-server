package com.alloiz.alloizserver.controller;

import static com.alloiz.alloizserver.dto.utils.builder.Builder.map;

import com.alloiz.alloizserver.dto.ImageDto;
import com.alloiz.alloizserver.model.Image;
import com.alloiz.alloizserver.service.ImageService;
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
@RequestMapping("/image")
public class ImageController {

  @Autowired
  private ImageService imageService;

  @GetMapping("/find-all")
  private ResponseEntity<List<ImageDto>> findAll(){
    return ResponseEntity.ok(imageService.findAll().stream()
        .map(image -> map(image,ImageDto.class)).collect(Collectors.toList()));
  }

  @GetMapping("/find-all-available")
  private ResponseEntity<List<ImageDto>> findAllAvailable(){
    return ResponseEntity.ok(imageService.findAllAvailable().stream()
        .map(image -> map(image,ImageDto.class)).collect(Collectors.toList()));
  }

  @GetMapping("/find-one-available/{id}")
  private ResponseEntity<ImageDto> findOneAvailale(@PathVariable Long id){
    return ResponseEntity.ok(map(imageService.findOneAvailable(id),ImageDto.class));
  }


  @GetMapping("/find-one/{id}")
  private ResponseEntity<ImageDto> findOne(@PathVariable Long id){
    return ResponseEntity.ok(map(imageService.findOne(id),ImageDto.class));
  }


  @PostMapping("/save")
  private ResponseEntity<ImageDto> save(@RequestBody ImageDto imageDto) {
    return ResponseEntity.ok(map(imageService.save(map(imageDto, Image.class)), ImageDto.class));
  }

  @DeleteMapping("/delete/{id}")
  private ResponseEntity delete(@PathVariable Long id){
    return new ResponseEntity(map(imageService.delete(id) ? HttpStatus.OK:HttpStatus.CONFLICT));
  }

  @PostMapping("/update")
  private ResponseEntity<ImageDto> update(@RequestBody ImageDto imageDto) {
    return ResponseEntity.ok(map(imageService.update(map(imageDto, Image.class)), ImageDto.class));
  }

}
