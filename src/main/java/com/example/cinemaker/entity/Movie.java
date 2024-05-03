package com.example.cinemaker.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String director;

    @Column(nullable = false)
    private String duration;

    @Column(nullable = false)
    private Date releaseDate;

    @Column(nullable = false)
    private String image;

    @OneToMany(mappedBy = "movie", orphanRemoval = true)
    @JsonIgnore
    private List<Schedule> schedules;
}
