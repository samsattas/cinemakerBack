package com.example.cinemaker.service;

import com.example.cinemaker.entity.Room;
import com.example.cinemaker.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;

    public List<Room> getAll() {return roomRepository.findAll();}

    public Optional<Room> getById(Long id) {return roomRepository.findById(id);}

    public void save(Room room){roomRepository.save(room); }

    public void delete(Long id){roomRepository.deleteById(id);}
}
