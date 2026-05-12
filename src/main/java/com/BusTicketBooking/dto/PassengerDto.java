package com.BusTicketBooking.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDto {

    private Long id;

    @NotBlank(message = "Name is Required")
    private String name;

    @NotBlank(message = "Email is Required")
    @Email(message = "Enter Valid Email")
    private String email;

    @NotBlank(message = "Phone Number is Required")
    private String phone;

    @NotNull(message = "Age is Required")
    @Positive(message = "Age Must be positive")
    private Integer age;
    private String gender;
}
