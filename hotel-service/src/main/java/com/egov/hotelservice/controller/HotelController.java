package com.egov.hotelservice.controller;


import com.egov.hotelservice.model.Hotel;

import com.egov.hotelservice.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
    private final HotelService service;

    public HotelController(HotelService service) { this.service = service; }

    @GetMapping
    public List<Hotel> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> byId(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Hotel create(@RequestBody Hotel obj) { return service.save(obj); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
