package com.BusTicketBooking.mapper;

import com.BusTicketBooking.dto.PassengerDto;
import com.BusTicketBooking.entity.Passenger;
import org.springframework.stereotype.Component;

@Component
public class PassengerMapper {
    public static Passenger toPassenger(PassengerDto dto) {
        Passenger passenger = new Passenger();
        passenger.setName(dto.getName());
        passenger.setEmail(dto.getEmail());
        passenger.setPhone(dto.getPhone());
        passenger.setAge(dto.getAge());
        passenger.setGender(dto.getGender());
        return passenger;
    }

    public static PassengerDto toPassengerDto(Passenger passenger) {
        PassengerDto dto = new PassengerDto();
        dto.setId(passenger.getId());
        dto.setName(passenger.getName());
        dto.setEmail(passenger.getEmail());
        dto.setPhone(passenger.getPhone());
        dto.setAge(passenger.getAge());
        dto.setGender(passenger.getGender());
        return dto;
    }
}
