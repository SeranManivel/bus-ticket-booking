package com.BusTicketBooking.service.impl;

import com.BusTicketBooking.dto.PassengerDto;
import com.BusTicketBooking.entity.Passenger;
import com.BusTicketBooking.exception.BusNotFoundException;
import com.BusTicketBooking.exception.PassengerNotFoundException;
import com.BusTicketBooking.mapper.PassengerMapper;
import com.BusTicketBooking.repository.PassengerRepository;
import com.BusTicketBooking.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;

    @Override
    public PassengerDto createPassenger(PassengerDto dto) {
        Passenger passenger = PassengerMapper.toPassenger(dto);
        return PassengerMapper.toPassengerDto(passengerRepository.save(passenger));
    }

    @Override
    public Page<PassengerDto> getAllPassengers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return passengerRepository.findAll(pageable).map(PassengerMapper::toPassengerDto);
    }

    @Override
    public PassengerDto getPassengerById(Long id) {
        Passenger passenger = passengerRepository.findById(id).orElseThrow(()->new PassengerNotFoundException("Passenger id Not found : "+id));
        return PassengerMapper.toPassengerDto(passenger);
    }

    @Override
    public PassengerDto updatePassenger(Long id, PassengerDto dto) {
        Passenger passenger = passengerRepository.findById(id).orElseThrow(()->new PassengerNotFoundException("Passenger id Not found : "+id));

        if (dto.getName() != null && !dto.getName().isBlank()) passenger.setName(dto.getName());
        if (dto.getEmail() != null && !dto.getEmail().isBlank()) passenger.setEmail(dto.getEmail());
        if (dto.getPhone() != null && !dto.getPhone().isBlank()) passenger.setPhone(dto.getPhone());
        if (dto.getAge() != null) passenger.setAge(dto.getAge());
        if (dto.getGender() != null) passenger.setGender(dto.getGender());

        return PassengerMapper.toPassengerDto(passengerRepository.save(passenger));
    }

    @Override
    public String deletePassenger(Long id) {
        Passenger passenger = passengerRepository.findById(id).orElseThrow(()->new PassengerNotFoundException("Passenger id Not found : "+id));

        passengerRepository.delete(passenger);
        return "Passenger deleted Succesfully";
    }
}
