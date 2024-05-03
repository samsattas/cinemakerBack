package com.example.cinemaker.controller;

import com.example.cinemaker.entity.Room;
import com.example.cinemaker.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<Room> getAll() { return roomService.getAll(); }

    @GetMapping("/{roomId}")
    public Optional<Room> getById(@PathVariable("roomId") Long roomId) {return roomService.getById(roomId);}

    @PostMapping
    public void post(@RequestBody Room room) {roomService.save(room);}

    @DeleteMapping("/{roomId}")
    public void delete(@PathVariable("roomId") Long roomId) {roomService.delete(roomId);}
}
