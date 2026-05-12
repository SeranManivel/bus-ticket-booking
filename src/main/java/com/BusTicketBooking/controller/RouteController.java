package com.BusTicketBooking.controller;

import com.BusTicketBooking.dto.RouteDto;
import com.BusTicketBooking.repository.RouteRepository;
import com.BusTicketBooking.service.RouteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/route")
@RequiredArgsConstructor
public class RouteController {
    private final RouteService routeService;

    @PostMapping
    public ResponseEntity<RouteDto> createRoute(@Valid @RequestBody RouteDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(routeService.createRoute(dto));
    }

    @GetMapping
    public ResponseEntity<Page<RouteDto>> getAllRoutes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size){
        return ResponseEntity.ok(routeService.getAllRoutes(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RouteDto> getRouteById(@PathVariable Long id){
        return ResponseEntity.ok(routeService.getRouteById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RouteDto> updateRoute(@PathVariable Long id,@Valid @RequestBody RouteDto dto){
        return ResponseEntity.ok(routeService.updateRoute(id,dto));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteRoute(@PathVariable Long id){
        return ResponseEntity.ok(routeService.deleteRoute(id));
    }

    @GetMapping("/bus/{busId}")
    public ResponseEntity<List<RouteDto>> getRoutesByBus(@PathVariable Long busId){
        return ResponseEntity.ok(routeService.getRoutesByBus(busId));
    }

    @GetMapping("/search")
    public ResponseEntity<List<RouteDto>> searchRoutes(
            @RequestParam String source,
            @RequestParam String destination){

        return ResponseEntity.ok(routeService.searchRoutes(source, destination));
    }
}