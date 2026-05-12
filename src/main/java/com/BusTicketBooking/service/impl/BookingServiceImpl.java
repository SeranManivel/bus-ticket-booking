package com.BusTicketBooking.service.impl;

import com.BusTicketBooking.dto.BookingDto;
import com.BusTicketBooking.entity.Booking;
import com.BusTicketBooking.entity.Passenger;
import com.BusTicketBooking.entity.Route;
import com.BusTicketBooking.exception.BookingNotFoundException;
import com.BusTicketBooking.exception.PassengerNotFoundException;
import com.BusTicketBooking.exception.RouteNotFoundException;
import com.BusTicketBooking.mapper.BookingMapper;
import com.BusTicketBooking.repository.BookingRepository;
import com.BusTicketBooking.repository.PassengerRepository;
import com.BusTicketBooking.repository.RouteRepository;
import com.BusTicketBooking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final PassengerRepository passengerRepository;
    private final RouteRepository routeRepository;

    @Override
    public BookingDto createBooking(BookingDto dto) {
        Passenger passenger = passengerRepository.findById(dto.getPassengerId()).orElseThrow(()->new PassengerNotFoundException("Passenger id not found : "+dto.getPassengerId()));

        Route route = routeRepository.findById(dto.getRouteId()).orElseThrow(()->new RouteNotFoundException("Route Id is Not found : "+dto.getRouteId()));

        Booking booking = BookingMapper.toBooking(dto,passenger,route);
        return BookingMapper.toBookingDto(bookingRepository.save(booking));
    }

    @Override
    public BookingDto getBookingId(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(()->new BookingNotFoundException("Booking Id id not Found : "+id));

        return BookingMapper.toBookingDto(booking);
    }

    @Override
    public Page<BookingDto> getAllBookings(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return bookingRepository.findAll(pageable).map(BookingMapper::toBookingDto);
    }

    @Override
    public String cancelBooking(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(()->new BookingNotFoundException("Booking id not found : "+id));

        bookingRepository.delete(booking);
        return "Bookind Deleted Sucessfully";
    }

    @Override
    public List<BookingDto> getBookingsByRoute(Long routeId) {
        routeRepository.findById(routeId).orElseThrow(()->new RouteNotFoundException("Route Id is not found : "+routeId));

        return bookingRepository.findByRouteId(routeId).stream()
                .map(BookingMapper::toBookingDto).collect(Collectors.toList());
    }

    @Override
    public List<BookingDto> getBookingsByPassenger(Long passengerId) {
        passengerRepository.findById(passengerId).orElseThrow(()->new PassengerNotFoundException("Passenger Id is not found : "+passengerId));

        return bookingRepository.findByPassengerId(passengerId).stream().map(BookingMapper::toBookingDto).collect(Collectors.toList());
    }
}
