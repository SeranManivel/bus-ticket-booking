package com.BusTicketBooking.service;

import com.BusTicketBooking.dto.RouteDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RouteService {
    RouteDto createRoute(RouteDto dto);
    Page<RouteDto> getAllRoutes(int page,int size);
    RouteDto getRouteById(Long id);
    RouteDto updateRoute(Long id,RouteDto dto);
    String deleteRoute(Long id);
    List<RouteDto> getRoutesByBus(Long busId);
    List<RouteDto> searchRoutes(String source,String destination);
}
