package com.alloiz.alloizserver.controller;

import com.alloiz.alloizserver.dto.WorkerFullDto;
import com.alloiz.alloizserver.dto.WorkerShortDto;
import com.alloiz.alloizserver.service.WorkerService;
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
@RequestMapping("/worker")
public class WorkerController {

    private static final Logger LOGGER = Logger.getLogger(WorkerController.class);

    @Autowired
    private WorkerService workerService;

    @GetMapping("/find-all")
    private ResponseEntity<List<WorkerShortDto>> findAll() {
        return new ResponseEntity<>(workerService.findAll().stream()
                .map(worker -> map(worker, WorkerShortDto.class)).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/find-all-available")
    private ResponseEntity<List<WorkerShortDto>> findAllAvailable() {
        return new ResponseEntity<>(workerService.findAllAvailable().stream()
                .map(worker -> map(worker, WorkerShortDto.class)).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/find-one-available/{id}")
    private ResponseEntity<WorkerShortDto> findOneAvailale(@PathVariable Long id) {
        return new ResponseEntity<>(map(workerService.findOneAvailable(id), WorkerShortDto.class), HttpStatus.OK);
    }


    @GetMapping("/find-one/{id}")
    private ResponseEntity<WorkerShortDto> findOne(@PathVariable Long id) {
        return new ResponseEntity<>(map(workerService.findOne(id), WorkerShortDto.class), HttpStatus.OK);
    }


    @PostMapping("/save")
    private ResponseEntity<WorkerFullDto> save(@RequestParam String workerJson, @RequestParam(required = false) MultipartFile multipartFile) {
        LOGGER.info(workerJson);
        return ResponseEntity.ok(map(workerService.save(workerJson, multipartFile), WorkerFullDto.class));
    }

//    @PostMapping("/update")
//    private ResponseEntity<WorkerFullDto> update(@RequestParam WorkerFullDto worker) {
//        return ResponseEntity.ok(map(workerService.update(map(worker, Worker.class)), WorkerFullDto.class));
//    }

    @PostMapping("/update")
    private ResponseEntity<WorkerFullDto> update(@RequestParam String workerJson, @RequestParam(required = false) MultipartFile multipartFile) {
        LOGGER.info(workerJson);
        if (multipartFile != null)
            return ResponseEntity.ok(map(workerService.update(workerJson, multipartFile), WorkerFullDto.class));
        else
            return ResponseEntity.ok(map(workerService.update(workerJson), WorkerFullDto.class));
    }


    @PostMapping("/update-image/{id}")
    private ResponseEntity<WorkerFullDto> updateImage(@RequestParam MultipartFile multipartFile, @PathVariable Long id) {
        return ResponseEntity.ok(map(workerService.updateImage(multipartFile, id), WorkerFullDto.class));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(workerService.delete(id));
    }


}
