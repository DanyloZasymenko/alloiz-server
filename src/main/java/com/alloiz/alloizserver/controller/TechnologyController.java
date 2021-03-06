package com.alloiz.alloizserver.controller;

import com.alloiz.alloizserver.dto.TechnologyDto;
import com.alloiz.alloizserver.dto.WorkerFullDto;
import com.alloiz.alloizserver.model.Technology;
import com.alloiz.alloizserver.service.TechnologyService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

import static com.alloiz.alloizserver.dto.utils.builder.Builder.map;

@RestController
@RequestMapping("/technology")
public class TechnologyController {

    private static final Logger LOGGER = Logger.getLogger(TechnologyController.class);

    @Autowired
    private TechnologyService technologyService;

    @GetMapping("/find-all")
    private ResponseEntity<List<TechnologyDto>> findAll() {
        return ResponseEntity.ok(technologyService.findAll().stream()
                .map(callback -> map(callback, TechnologyDto.class)).collect(Collectors.toList()));
    }

    @GetMapping("/find-all-available")
    private ResponseEntity<List<TechnologyDto>> findAllAvailable() {
        return ResponseEntity.ok(technologyService.findAllAvailable().stream()
                .map(callback -> map(callback, TechnologyDto.class)).collect(Collectors.toList()));
    }

    @GetMapping("/find-one-available/{id}")
    private ResponseEntity<TechnologyDto> findOneAvailale(@PathVariable Long id) {
        return ResponseEntity.ok(map(technologyService.findOneAvailable(id), TechnologyDto.class));
    }


    @GetMapping("/find-one/{id}")
    private ResponseEntity<TechnologyDto> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(map(technologyService.findOne(id), TechnologyDto.class));
    }


    @PostMapping("/save")
    private ResponseEntity<TechnologyDto> save(@RequestParam String technologyJson,
                                               @RequestParam(required = false) MultipartFile multipartFile) {
        return ResponseEntity.ok(
                map(technologyService.save(technologyJson, multipartFile), TechnologyDto.class));
    }

//    @PostMapping("/update")
//    private ResponseEntity<TechnologyDto> update(@RequestBody TechnologyDto technology) {
//        return ResponseEntity.ok(map(technologyService.update(map(technology, Technology.class)), TechnologyDto.class));
//    }

    @PostMapping("/update")
    private ResponseEntity<TechnologyDto> update(@RequestParam String technologyJson, @RequestParam(required = false) MultipartFile multipartFile) {
        LOGGER.info("---------------------------Worker---------------------");
        LOGGER.info(technologyJson);
        LOGGER.info("-----------END----------------Worker------------END---------");
        LOGGER.info("-----------------------------FILE-----------------------------");
        LOGGER.info(multipartFile==null?"null":multipartFile.getName());
        LOGGER.info("-------------END----------------FILE-----------------END------------");
        if (multipartFile != null && !multipartFile.isEmpty()){
            LOGGER.info("file not null");
            return ResponseEntity.ok(map(technologyService.update(technologyJson, multipartFile), TechnologyDto.class));
        }
        else {
            LOGGER.info("file is null (in else clause)");
            return ResponseEntity.ok(map(technologyService.update(technologyJson), TechnologyDto.class));
        }
    }

    @PostMapping("/update-image/{id}")
    private ResponseEntity<TechnologyDto> updateImage(@RequestParam MultipartFile multipartFile, @PathVariable Long id) {
        return ResponseEntity.ok(map(technologyService.updateImage(multipartFile, id), TechnologyDto.class));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity delete(@PathVariable Long id) {
        return ResponseEntity.ok(technologyService.delete(id));
    }
}
