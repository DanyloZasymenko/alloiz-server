package com.alloiz.alloizserver.controller;

import com.alloiz.alloizserver.dto.WorkerShortDto;
import com.alloiz.alloizserver.model.Worker;
import com.alloiz.alloizserver.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.alloiz.alloizserver.dto.utils.builder.Builder.map;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @GetMapping("/find-all")
    private ResponseEntity<List<WorkerShortDto>>findAll(){
        return new ResponseEntity<>(workerService.findAll().stream()
                .map(worker -> map(worker,WorkerShortDto.class)).collect(Collectors.toList()), HttpStatus.OK);
    }
    
    @GetMapping("/find-all-available")
    private ResponseEntity<List<WorkerShortDto>> findAllAvailable(){
        return new ResponseEntity<>(workerService.findAllAvailable().stream()
                .map(worker -> map(worker,WorkerShortDto.class)).collect(Collectors.toList()),HttpStatus.OK);
    }

    @GetMapping("/find-one-available/{id}")
    private ResponseEntity<WorkerShortDto> findOneAvailale(@PathVariable Long id){
        return new ResponseEntity<>(map(workerService.findOneAvailable(id),WorkerShortDto.class),HttpStatus.OK);
    }


    @GetMapping("/find-one/{id}")
    private ResponseEntity<WorkerShortDto> findOne(@PathVariable Long id){
        return new ResponseEntity<>(map(workerService.findOne(id),WorkerShortDto.class),HttpStatus.OK);
    }


    @PostMapping("/save")
    private ResponseEntity<WorkerShortDto> save(@RequestBody WorkerShortDto workerShortDto) {
        return ResponseEntity.ok(map(workerService.save(map(workerShortDto, Worker.class)), WorkerShortDto.class));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity delete(@PathVariable Long id){
        return new ResponseEntity(map(workerService.delete(id) ? HttpStatus.OK:HttpStatus.CONFLICT));
    }






}
