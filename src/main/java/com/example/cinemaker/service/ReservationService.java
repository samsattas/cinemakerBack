package com.example.cinemaker.service;

import com.example.cinemaker.entity.Reservation;
import com.example.cinemaker.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    public List<Reservation> getAll() {return reservationRepository.findAll();}

    public Optional<Reservation> getById(Long id) {return reservationRepository.findById(id);}

    public void save(Reservation reservation){
        reservationRepository.save(reservation);
    }

    public void delete(Long id){reservationRepository.deleteById(id);}
}
