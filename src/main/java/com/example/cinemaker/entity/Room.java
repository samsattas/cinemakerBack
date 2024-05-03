package com.example.cinemaker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int roomNumber;

    @Column(nullable = false)
    private int capacity;

    @OneToMany(mappedBy = "room", orphanRemoval = true)
    private List<Schedule> schedules;
}
