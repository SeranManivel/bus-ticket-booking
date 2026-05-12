package com.BusTicketBooking.controller;

import com.BusTicketBooking.dto.PassengerDto;
import com.BusTicketBooking.service.PassengerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passenger")
@RequiredArgsConstructor
public class PassengerController {
    private final PassengerService passengerService;

    @PostMapping
    public ResponseEntity<PassengerDto> createPassenger(@Valid @RequestBody PassengerDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(passengerService.createPassenger(dto));
    }

    @GetMapping
    public ResponseEntity<Page<PassengerDto>> getAllPassengers(
            @RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5") int size){
        return ResponseEntity.ok(passengerService.getAllPassengers(page,size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassengerDto> getPassengerById(@PathVariable Long id){
        return ResponseEntity.ok(passengerService.getPassengerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PassengerDto> updatePassenger(@PathVariable Long id,@Valid @RequestBody PassengerDto dto){
        return ResponseEntity.ok(passengerService.updatePassenger(id,dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePassenger(@PathVariable Long id){
        return ResponseEntity.ok(passengerService.deletePassenger(id));
    }
}
