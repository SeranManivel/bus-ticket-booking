package com.BusTicketBooking.mapper;

import com.BusTicketBooking.dto.BusDto;
import com.BusTicketBooking.entity.Bus;
import org.springframework.stereotype.Component;

@Component
public class BusMapper {

    public static Bus toBus(BusDto dto){
        Bus bus = new Bus();
        bus.setBusNumber(dto.getBusNumber());
        bus.setBusName(dto.getBusName());
        bus.setBusType(dto.getBusType());
        bus.setActive(dto.getActive());
        bus.setTotalSeat(dto.getTotalSeat());
        return bus;
    }

    public static BusDto toBusDto(Bus bus){

        BusDto dto = new BusDto();
        dto.setId(bus.getId());
        dto.setBusNumber(bus.getBusNumber());
        dto.setBusName(bus.getBusName());
        dto.setTotalSeat(bus.getTotalSeat());
        dto.setBusType(bus.getBusType());
        dto.setActive(bus.getActive());


        return dto;
    }
}
