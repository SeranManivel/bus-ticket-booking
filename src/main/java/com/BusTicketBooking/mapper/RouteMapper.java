package com.BusTicketBooking.mapper;

import com.BusTicketBooking.dto.RouteDto;
import com.BusTicketBooking.entity.Bus;
import com.BusTicketBooking.entity.Route;
import org.springframework.stereotype.Component;

@Component
public class RouteMapper {
    public static Route toRoute(RouteDto dto, Bus bus) {
        Route route = new Route();
        route.setSource(dto.getSource());
        route.setDestination(dto.getDestination());
        route.setFare(dto.getFare());
        route.setDepartureTime(dto.getDepartureTime());
        route.setArrivalTime(dto.getArrivalTime());
        route.setDistanceKm(dto.getDistanceKm());
        route.setBus(bus);
        return route;
    }

    public static RouteDto toRouteDto(Route route) {
        RouteDto dto = new RouteDto();
        dto.setId(route.getId());
        dto.setSource(route.getSource());
        dto.setDestination(route.getDestination());
        dto.setFare(route.getFare());
        dto.setDepartureTime(route.getDepartureTime());
        dto.setArrivalTime(route.getArrivalTime());
        dto.setDistanceKm(route.getDistanceKm());
        dto.setBusId(route.getBus().getId());
        return dto;
    }
}
