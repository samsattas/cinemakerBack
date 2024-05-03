package com.example.cinemaker.controller;

import com.example.cinemaker.entity.Schedule;
import com.example.cinemaker.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/schedules")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping
    public List<Schedule> getAll() { return scheduleService.getAll(); }

    @GetMapping("/{scheduleId}")
    public Optional<Schedule> getById(@PathVariable("scheduleId") Long scheduleId) {return scheduleService.getById(scheduleId);}

    @PostMapping
    public void post(@RequestBody Schedule schedule) {scheduleService.save(schedule);}

    @DeleteMapping("/{scheduleId}")
    public void delete(@PathVariable("scheduleId") Long scheduleId) {scheduleService.delete(scheduleId);}
}
