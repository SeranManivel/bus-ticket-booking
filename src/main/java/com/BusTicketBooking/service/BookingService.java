package com.BusTicketBooking.service;

import com.BusTicketBooking.dto.BookingDto;
import com.BusTicketBooking.entity.Booking;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookingService {

    BookingDto createBooking(BookingDto dto);
    Page<BookingDto> getAllBookings(int page,int size);
    BookingDto getBookingId(Long id);
    String cancelBooking(Long id);
    List<BookingDto> getBookingsByPassenger(Long passengerId);
    List<BookingDto> getBookingsByRoute(Long routeId);
}
