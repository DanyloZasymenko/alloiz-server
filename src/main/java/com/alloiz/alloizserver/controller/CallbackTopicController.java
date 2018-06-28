package com.alloiz.alloizserver.controller;

import com.alloiz.alloizserver.dto.CallbackTopicShortDto;
import com.alloiz.alloizserver.model.CallbackTopic;
import com.alloiz.alloizserver.service.CallbackTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.alloiz.alloizserver.dto.utils.builder.Builder.map;

@RestController
@RequestMapping("/callback-topic")
public class CallbackTopicController {

    @Autowired
    private CallbackTopicService callbackTopicService;

    @GetMapping("/find-all")
    private ResponseEntity<List<CallbackTopicShortDto>> findAll(){
        return ResponseEntity.ok(callbackTopicService.findAll().stream()
                .map(callbackTopic -> map(callbackTopic,CallbackTopicShortDto.class)).collect(Collectors.toList()));
    }

    @GetMapping("/find-all-available")
    private ResponseEntity<List<CallbackTopicShortDto>> findAllAvailable(){
        return ResponseEntity.ok(callbackTopicService.findAllAvailable().stream()
                .map(callbackTopic -> map(callbackTopic,CallbackTopicShortDto.class)).collect(Collectors.toList()));
    }

    @GetMapping("/find-one-available/{id}")
    private ResponseEntity<CallbackTopicShortDto> findOneAvailale(@PathVariable Long id){
        return ResponseEntity.ok(map(callbackTopicService.findOneAvailable(id),CallbackTopicShortDto.class));
    }


    @GetMapping("/find-one/{id}")
    private ResponseEntity<CallbackTopicShortDto> findOne(@PathVariable Long id){
        return ResponseEntity.ok(map(callbackTopicService.findOne(id),CallbackTopicShortDto.class));
    }


    @PostMapping("/save")
    private ResponseEntity<CallbackTopicShortDto> save(@RequestBody CallbackTopicShortDto callbackTopicShortDto) {
        return ResponseEntity.ok(map(callbackTopicService.save(map(callbackTopicShortDto, CallbackTopic.class)), CallbackTopicShortDto.class));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity delete(@PathVariable Long id){
        return new ResponseEntity(map(callbackTopicService.delete(id) ? HttpStatus.OK:HttpStatus.CONFLICT));
    }
}
