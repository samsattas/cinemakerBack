package com.example.cinemaker.controller;

import com.example.cinemaker.entity.Reservation;
import com.example.cinemaker.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public List<Reservation> getAll() { return reservationService.getAll(); }

    @GetMapping("/{reservationId}")
    public Optional<Reservation> getById(@PathVariable("reservationId") Long reservationId) {return reservationService.getById(reservationId);}

    @PostMapping
    public void post(@RequestBody Reservation reservation) {reservationService.save(reservation);}

    @DeleteMapping("/{reservationId}")
    public void delete(@PathVariable("reservationId") Long reservationId) {reservationService.delete(reservationId);}
}
