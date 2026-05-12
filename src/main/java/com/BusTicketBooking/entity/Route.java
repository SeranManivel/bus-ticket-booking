package com.BusTicketBooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String source;
    private String destination;
    private Double fare;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private Integer distanceKm;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

    @CreationTimestamp
    private LocalDateTime createdTime;

    @UpdateTimestamp
    private  LocalDateTime updatedTime;
}
