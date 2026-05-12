package com.BusTicketBooking.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteDto {

    private Long id;

    @NotBlank(message = "Source is required")
    private String source;

    @NotBlank(message = "Destination is required")
    private String destination;

    @NotNull(message = "Fare Is required")
    @Positive(message = "Fare Must be grater than 0")
    private Double fare;

    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private Integer distanceKm;

    @NotNull(message = "Bus Id Is required")
    private Long busId;
}
