package com.alloiz.alloizserver.controller;

import com.alloiz.alloizserver.service.OrderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-type")
public class OrderTypeController {

    @Autowired
    private OrderTypeService orderTypeService;

    @GetMapping("/find-all")
    private ResponseEntity<List<OrderType>> findAll() {
        return ResponseEntity.ok(orderTypeService.findAll());
    }

    @GetMapping("/find-all-available")
    private ResponseEntity<List<OrderType>> findAllAvailable() {
        return ResponseEntity.ok(orderTypeService.findAllAvailable());
    }

    @GetMapping("/find-one-available/{id}")
    private ResponseEntity<OrderType> findOneAvailale(@PathVariable Long id) {
        return ResponseEntity.ok(orderTypeService.findOneAvailable(id));
    }

    @GetMapping("/find-one/{id}")
    private ResponseEntity<OrderType> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(orderTypeService.findOne(id));
    }

    @PostMapping("/save")
    private ResponseEntity<OrderType> save(@RequestBody OrderType orderType) {
        return ResponseEntity.ok(map(orderTypeService.save(orderType), OrderType.class));
    }

    @PostMapping("/update")
    private ResponseEntity<OrderType> update(@RequestBody OrderType orderType) {
        return ResponseEntity.ok(orderTypeService.update(orderType));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity delete(@PathVariable Long id) {
        return ResponseEntity.ok(orderTypeService.delete(id));
    }
}
