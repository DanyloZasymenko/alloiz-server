package com.alloiz.alloizserver.controller;

import static com.alloiz.alloizserver.dto.utils.builder.Builder.map;

import com.alloiz.alloizserver.dto.CallbackFullDto;
import com.alloiz.alloizserver.dto.CallbackShortDto;
import com.alloiz.alloizserver.model.Callback;
import com.alloiz.alloizserver.service.CallbackService;
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
@RequestMapping("/callback")
public class CallbackController {

  @Autowired
  private CallbackService callbackService;

  @GetMapping("/find-all")
  private ResponseEntity<List<CallbackShortDto>> findAll(){
    return ResponseEntity.ok(callbackService.findAll().stream()
        .map(callback -> map(callback,CallbackShortDto.class)).collect(Collectors.toList()));
  }

  @GetMapping("/find-all-available")
  private ResponseEntity<List<CallbackShortDto>> findAllAvailable(){
    return ResponseEntity.ok(callbackService.findAllAvailable().stream()
        .map(callback -> map(callback,CallbackShortDto.class)).collect(Collectors.toList()));
  }

  @GetMapping("/find-one-available/{id}")
  private ResponseEntity<CallbackFullDto> findOneAvailale(@PathVariable Long id){
    return ResponseEntity.ok(map(callbackService.findOneAvailable(id),CallbackFullDto.class));
  }


  @GetMapping("/find-one/{id}")
  private ResponseEntity<CallbackFullDto> findOne(@PathVariable Long id){
    return ResponseEntity.ok(map(callbackService.findOne(id),CallbackFullDto.class));
  }


  @PostMapping("/save")
  private ResponseEntity<CallbackFullDto> save(@RequestBody CallbackFullDto callbackFullDto) {
    return ResponseEntity.ok(map(callbackService.save(map(callbackFullDto, Callback.class)), CallbackFullDto.class));
  }

  @DeleteMapping("/delete/{id}")
  private ResponseEntity delete(@PathVariable Long id){
    return new ResponseEntity(map(callbackService.delete(id) ? HttpStatus.OK:HttpStatus.CONFLICT));
  }
}
