package com.BusTicketBooking.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusDto {

    private Long id;

    @NotBlank(message = "Bus Number is required")
    private String busNumber;

    @NotBlank(message = "Bus Name is required")
    private String busName;

    @NotBlank(message = "Bus Type is Required")
    private String busType;

    @NotNull(message = "Total Seat is Required")
    @Positive(message = "Total seat is Must be positive")
    private Integer totalSeat;

    private Boolean active;
}
