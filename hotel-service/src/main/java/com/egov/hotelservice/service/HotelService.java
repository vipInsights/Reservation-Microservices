package com.egov.hotelservice.service;


import com.egov.hotelservice.model.Hotel;
import com.egov.hotelservice.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    private final HotelRepository repo;

    public HotelService(HotelRepository repo) {
        this.repo = repo;
    }

    public List<Hotel> findAll() { return repo.findAll(); }
    public Optional<Hotel> findById(String id) { return repo.findById(id); }
    public Hotel save(Hotel obj) { return repo.save(obj); }
    public void delete(String id) { repo.deleteById(id); }
}
