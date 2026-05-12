package com.BusTicketBooking.controller;

import com.BusTicketBooking.dto.BookingDto;
import com.BusTicketBooking.service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingDto> createBooking(@Valid @RequestBody BookingDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.createBooking(dto));
    }

    @GetMapping
    public ResponseEntity<Page<BookingDto>> getAllBookings(
            @RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5") int size){
        return ResponseEntity.ok(bookingService.getAllBookings(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDto> getBookingId(@PathVariable Long id){
        return ResponseEntity.ok(bookingService.getBookingId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelBooking(@PathVariable Long id){
        return ResponseEntity.ok(bookingService.cancelBooking(id));
    }

    @GetMapping("/passenger/{passengerId}")
    public ResponseEntity<List<BookingDto>> getBookingsByPassenger(@PathVariable Long passengerId){
        return ResponseEntity.ok(bookingService.getBookingsByPassenger(passengerId));
    }

    @GetMapping("/route/{routeId}")
    public ResponseEntity<List<BookingDto>> getBookingsByRoute(Long routeId){
        return ResponseEntity.ok(bookingService.getBookingsByRoute(routeId));
    }
}
