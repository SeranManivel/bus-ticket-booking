package com.BusTicketBooking.service;

import com.BusTicketBooking.dto.PassengerDto;
import org.springframework.data.domain.Page;

public interface PassengerService {
    PassengerDto createPassenger(PassengerDto dto);
    Page<PassengerDto> getAllPassengers(int page,int size);
    PassengerDto getPassengerById(Long id);
    PassengerDto updatePassenger(Long id,PassengerDto dto);
    String deletePassenger(Long id);
}
