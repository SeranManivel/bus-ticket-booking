package com.BusTicketBooking.service.impl;

import com.BusTicketBooking.dto.BusDto;
import com.BusTicketBooking.entity.Bus;
import com.BusTicketBooking.exception.BusNotFoundException;
import com.BusTicketBooking.mapper.BusMapper;
import com.BusTicketBooking.repository.BusRepository;
import com.BusTicketBooking.service.BusService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.NullServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BusServiceImpl implements BusService {

    private final BusRepository busRepository;

    @Override
    public BusDto createBus(BusDto dto) {
        Bus bus = BusMapper.toBus(dto);
        return BusMapper.toBusDto(busRepository.save(bus));
    }

    @Override
    public Page<BusDto> getAllBuses(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return busRepository.findAll(pageable).map(BusMapper::toBusDto);
    }

    @Override
    public BusDto getBusById(Long id) {
        Bus bus = busRepository.findById(id).orElseThrow(()-> new BusNotFoundException("Bus Not found with id : "+id));

        return BusMapper.toBusDto(bus);
    }

    @Override
    public BusDto updateBus(Long id, BusDto dto) {
        Bus bus = busRepository.findById(id).orElseThrow(() -> new BusNotFoundException("Bus Not found with id : "+id));
        if (dto.getBusNumber() != null && dto.getBusNumber().isBlank()){bus.setBusName(dto.getBusName());}
        if (dto.getBusName() != null && !dto.getBusName().isBlank()) bus.setBusName(dto.getBusName());
        if (dto.getBusType() != null && !dto.getBusType().isBlank()) bus.setBusType(dto.getBusType());
        if (dto.getTotalSeat() != null) bus.setTotalSeat(dto.getTotalSeat());
        if (dto.getActive() != null) bus.setActive(dto.getActive());

        return BusMapper.toBusDto(busRepository.save(bus));
    }

    @Override
    public String deleteBus(Long id) {
        Bus bus = busRepository.findById(id).orElseThrow(()-> new BusNotFoundException("Bus Not found with id : "+id));
        busRepository.delete(bus);
        return "Bus Deleted Succesfully";
    }

    @Override
    public List<BusDto> getBusByType(String type) {
        return busRepository.findByBusType(type).stream().map(BusMapper::toBusDto).collect(Collectors.toList());
    }
}
