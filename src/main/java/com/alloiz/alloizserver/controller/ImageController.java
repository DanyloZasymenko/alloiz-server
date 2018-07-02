package com.alloiz.alloizserver.controller;

import com.alloiz.alloizserver.dto.ImageDto;
import com.alloiz.alloizserver.model.Image;
import com.alloiz.alloizserver.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

import static com.alloiz.alloizserver.dto.utils.builder.Builder.map;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/find-all")
    private ResponseEntity<List<ImageDto>> findAll() {
        return ResponseEntity.ok(imageService.findAll().stream()
                .map(image -> map(image, ImageDto.class)).collect(Collectors.toList()));
    }

    @GetMapping("/find-all-available")
    private ResponseEntity<List<ImageDto>> findAllAvailable() {
        return ResponseEntity.ok(imageService.findAllAvailable().stream()
                .map(image -> map(image, ImageDto.class)).collect(Collectors.toList()));
    }

    @GetMapping("/find-one-available/{id}")
    private ResponseEntity<ImageDto> findOneAvailale(@PathVariable Long id) {
        return ResponseEntity.ok(map(imageService.findOneAvailable(id), ImageDto.class));
    }

    @GetMapping("/find-one/{id}")
    private ResponseEntity<ImageDto> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(map(imageService.findOne(id), ImageDto.class));
    }

    @PostMapping("/save/{id}")
    private ResponseEntity save(@RequestParam MultipartFile multipartFile, @PathVariable Long portfolioId) {
        return ResponseEntity.ok(imageService.save(multipartFile, portfolioId));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(imageService.delete(id));
    }

    @PostMapping("/update")
    private ResponseEntity<ImageDto> update(@RequestBody ImageDto imageDto) {
        return ResponseEntity.ok(map(imageService.update(map(imageDto, Image.class)), ImageDto.class));
    }

}
