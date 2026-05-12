package com.BusTicketBooking.repository;

import com.BusTicketBooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long>{
    List<Booking> findByPassengerId(Long passengerId);
    List<Booking> findByRouteId(Long routeId);

}
