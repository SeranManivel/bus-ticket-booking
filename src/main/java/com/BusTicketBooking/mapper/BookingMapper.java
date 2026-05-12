package com.BusTicketBooking.mapper;

import com.BusTicketBooking.dto.BookingDto;
import com.BusTicketBooking.entity.Booking;
import com.BusTicketBooking.entity.Passenger;
import com.BusTicketBooking.entity.Route;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {
    public static Booking toBooking(BookingDto dto, Passenger passenger, Route route) {
        Booking booking = new Booking();
        booking.setSeatNumber(dto.getSeatNumber());
        booking.setTravelDate(dto.getTravelDate());
        booking.setStatus("CONFIRMED");
        booking.setTotalFare(route.getFare());
        booking.setPassenger(passenger);
        booking.setRoute(route);
        return booking;
    }

    public static BookingDto toBookingDto(Booking booking) {
        BookingDto dto = new BookingDto();
        dto.setId(booking.getId());
        dto.setSeatNumber(booking.getSeatNumber());
        dto.setTravelDate(booking.getTravelDate());
        dto.setStatus(booking.getStatus());
        dto.setTotalFare(booking.getTotalFare());
        dto.setPassengerId(booking.getPassenger().getId());
        dto.setRouteId(booking.getRoute().getId());
        return dto;
    }
}
