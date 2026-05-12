package com.BusTicketBooking.service.impl;

import com.BusTicketBooking.dto.RouteDto;
import com.BusTicketBooking.entity.Bus;
import com.BusTicketBooking.entity.Route;
import com.BusTicketBooking.exception.BusNotFoundException;
import com.BusTicketBooking.mapper.RouteMapper;
import com.BusTicketBooking.repository.BusRepository;
import com.BusTicketBooking.repository.RouteRepository;
import com.BusTicketBooking.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {

    private final BusRepository busRepository;
    private final RouteRepository routeRepository;

    @Override
    public RouteDto createRoute(RouteDto dto) {
        Bus bus = busRepository.findById(dto.getBusId()).orElseThrow(()-> new BusNotFoundException("Bus not found with id: " + dto.getBusId()));
        Route route = RouteMapper.toRoute(dto,bus);

        return RouteMapper.toRouteDto(routeRepository.save(route));
    }

    @Override
    public Page<RouteDto> getAllRoutes(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return routeRepository.findAll(pageable).map(RouteMapper::toRouteDto);
    }

    @Override
    public RouteDto getRouteById(Long id) {
        Route route = routeRepository.findById(id).orElseThrow(()-> new BusNotFoundException("Bus not found with id: " + id));
        return RouteMapper.toRouteDto(route);
    }

    @Override
    public RouteDto updateRoute(Long id, RouteDto dto) {
        Route route = routeRepository.findById(id).orElseThrow(()-> new BusNotFoundException("Bus not found with id: " +id));

        if (dto.getSource() !=null && !dto.getSource().isBlank()) route.setSource(dto.getSource());
        if (dto.getDestination() != null && !dto.getDestination().isBlank()) route.setDestination(dto.getDestination());
        if (dto.getFare() != null) route.setFare(dto.getFare());
        if (dto.getDepartureTime() != null) route.setDepartureTime(dto.getDepartureTime());
        if (dto.getArrivalTime() != null) route.setArrivalTime(dto.getArrivalTime());
        if (dto.getDistanceKm() != null) route.setDistanceKm(dto.getDistanceKm());

        if (dto.getBusId() !=null){
            Bus bus = busRepository.findById(dto.getBusId()).orElseThrow(()-> new BusNotFoundException("Bus not found with id: " + dto.getBusId()));
            route.setBus(bus);
        }
        return RouteMapper.toRouteDto(routeRepository.save(route));
    }

    @Override
    public String deleteRoute(Long id) {
        Route route = routeRepository.findById(id).orElseThrow(()->new BusNotFoundException("Bus not found with id: " + id));
        routeRepository.delete(route);
        return "Route Deleted Sucessfully";
    }

    @Override
    public List<RouteDto> getRoutesByBus(Long busId) {
            busRepository.findById(busId).orElseThrow(()->new BusNotFoundException("Bus not found with id: " + busId));

            return routeRepository.findByBusId(busId).stream()
                    .map(RouteMapper::toRouteDto).collect(Collectors.toList());
    }

    @Override
    public List<RouteDto> searchRoutes(String source, String destination) {
        return routeRepository.findBySourceAndDestination(source, destination).stream().map(RouteMapper::toRouteDto).collect(Collectors.toList());
    }
}
