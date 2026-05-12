package com.BusTicketBooking.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {

    private Long id;

    @NotNull(message = "Seat Number is Required")
    @Positive(message = "Seat Number must Be positive")
    private Integer seatNumber;

    @NotNull(message = "Travel Date is Required")
    @Future(message = "Travel date must be a Future Date")
    private LocalDate travelDate;

    private String status;

    private Double totalFare;

    @NotNull(message = "Passenger ID is required")
    private Long passengerId;

    @NotNull(message = "Route ID is required")
    private Long routeId;
}
