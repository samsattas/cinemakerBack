package com.example.cinemaker.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String clientName;

    @Column(nullable = false)
    private String clientEmail;

    @Column(nullable = false)
    private int clientPhone;

    @Column(nullable = false)
    private int numberOfSeats;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "reservation_schedule",
            joinColumns = @JoinColumn(name = "reservation_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "schedule_id", referencedColumnName = "id")
    )
    private Schedule schedule;
}
