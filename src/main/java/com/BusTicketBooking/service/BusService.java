package com.BusTicketBooking.service;

import com.BusTicketBooking.dto.BusDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BusService {
    BusDto createBus(BusDto dto);
    Page<BusDto> getAllBuses(int page , int size);
    BusDto getBusById(Long id);
    BusDto updateBus(Long id,BusDto dto);
    String deleteBus(Long id);
    List<BusDto> getBusByType(String type);
}
