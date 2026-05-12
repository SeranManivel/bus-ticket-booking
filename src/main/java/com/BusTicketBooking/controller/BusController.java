package com.BusTicketBooking.controller;

import com.BusTicketBooking.dto.BookingDto;
import com.BusTicketBooking.dto.BusDto;
import com.BusTicketBooking.entity.Bus;
import com.BusTicketBooking.service.BusService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
@RequiredArgsConstructor
public class BusController {

    private final BusService busService;

    @PostMapping
    public ResponseEntity<BusDto> createBus(@Valid @RequestBody BusDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(busService.createBus(dto));
    }

    @GetMapping
    public ResponseEntity<Page<BusDto>> getAllBuses(
            @RequestParam(defaultValue = "0") int page ,
            @RequestParam(defaultValue = "5") int size){
        return ResponseEntity.ok(busService.getAllBuses(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusDto> getBusById(@PathVariable Long id){
        return ResponseEntity.ok(busService.getBusById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusDto> updateBus(@PathVariable Long id,@RequestBody BusDto dto){
        return ResponseEntity.ok(busService.updateBus(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBus(@PathVariable Long id){
        return ResponseEntity.ok(busService.deleteBus(id));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<BusDto>> getBusByType(@PathVariable String type){
        return ResponseEntity.ok(busService.getBusByType(type));
    }

}
