package com.BusTicketBooking.repository;

import com.BusTicketBooking.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route,Long> {
    List<Route> findByBusId(Long busId);
    List<Route> findBySourceAndDestination(String source , String destination   );
}
