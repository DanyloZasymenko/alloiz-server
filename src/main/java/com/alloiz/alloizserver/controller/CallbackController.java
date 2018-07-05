package com.alloiz.alloizserver.controller;

import static com.alloiz.alloizserver.dto.utils.builder.Builder.map;

import com.alloiz.alloizserver.dto.CallbackDto;
import com.alloiz.alloizserver.model.Callback;
import com.alloiz.alloizserver.service.CallbackService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/callback")
public class CallbackController {

  @Autowired
  private CallbackService callbackService;

  @GetMapping("/find-all")
  private ResponseEntity<List<CallbackDto>> findAll() {
    return ResponseEntity.ok(callbackService.findAll().stream()
        .map(callback -> map(callback, CallbackDto.class)).collect(Collectors.toList()));
  }

  @GetMapping("/find-all-available")
  private ResponseEntity<List<CallbackDto>> findAllAvailable() {
    return ResponseEntity.ok(callbackService.findAllAvailable().stream()
        .map(callback -> map(callback, CallbackDto.class)).collect(Collectors.toList()));
  }

  @GetMapping("/find-one-available/{id}")
  private ResponseEntity<CallbackDto> findOneAvailale(@PathVariable Long id) {
    return ResponseEntity.ok(map(callbackService.findOneAvailable(id), CallbackDto.class));
  }


  @GetMapping("/find-one/{id}")
  private ResponseEntity<CallbackDto> findOne(@PathVariable Long id) {
    return ResponseEntity.ok(map(callbackService.findOne(id), CallbackDto.class));
  }

  @PostMapping("/save")
  private ResponseEntity<CallbackDto> save(@RequestBody CallbackDto callback) {
    return ResponseEntity
        .ok(map(callbackService.save(map(callback, Callback.class)), CallbackDto.class));
  }

  @PostMapping("/update")
  private ResponseEntity<CallbackDto> update(@RequestBody CallbackDto callback) {
    return ResponseEntity
        .ok(map(callbackService.update(map(callback, Callback.class)), CallbackDto.class));
  }

  @DeleteMapping("/delete/{id}")
  private ResponseEntity<Boolean> delete(@PathVariable Long id) {
    return ResponseEntity.ok(callbackService.delete(id));
  }
}
