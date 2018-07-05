package com.alloiz.alloizserver.controller;

import com.alloiz.alloizserver.dto.CallbackTopicFullDto;
import com.alloiz.alloizserver.dto.CallbackTopicShortDto;
import com.alloiz.alloizserver.service.CallbackTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/callback-topic")
public class CallbackTopicController {

    @Autowired
    private CallbackTopicService callbackTopicService;

    @GetMapping("/find-all")
    private ResponseEntity<List<CallbackTopicShortDto>> findAll() {
        return ResponseEntity.ok(callbackTopicService.findAll().stream()
                .map(callbackTopic -> map(callbackTopic, CallbackTopicShortDto.class)).collect(Collectors.toList()));
    }

    @GetMapping("/find-all-available")
    private ResponseEntity<List<CallbackTopicShortDto>> findAllAvailable() {
        return ResponseEntity.ok(callbackTopicService.findAllAvailable().stream()
                .map(callbackTopic -> map(callbackTopic, CallbackTopicShortDto.class)).collect(Collectors.toList()));
    }

    @GetMapping("/find-one-available/{id}")
    private ResponseEntity<CallbackTopicFullDto> findOneAvailale(@PathVariable Long id) {
        return ResponseEntity.ok(map(callbackTopicService.findOneAvailable(id), CallbackTopicFullDto.class));
    }

    @GetMapping("/find-one/{id}")
    private ResponseEntity<CallbackTopicFullDto> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(map(callbackTopicService.findOne(id), CallbackTopicFullDto.class));
    }

    @PostMapping("/save")
    private ResponseEntity<CallbackTopicFullDto> save(@RequestBody CallbackTopicFullDto callbackTopic) {
        return ResponseEntity.ok(map(callbackTopicService.save(map(callbackTopic, CallbackTopic.class)), CallbackTopicFullDto.class));
    }

    @PostMapping("/update")
    private ResponseEntity<CallbackTopicFullDto> update(@RequestBody CallbackTopicFullDto callbackTopic) {
        return ResponseEntity.ok(map(callbackTopicService.update(map(callbackTopic, CallbackTopic.class)), CallbackTopicFullDto.class));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(callbackTopicService.delete(id));
    }
}
