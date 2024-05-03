package com.example.cinemaker.service;

import com.example.cinemaker.entity.Schedule;
import com.example.cinemaker.repository.MovieRepository;
import com.example.cinemaker.repository.ScheduleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }

    public Optional<Schedule> getById(Long id) {
        return scheduleRepository.findById(id);
    }

    public void save(Schedule schedule) {scheduleRepository.save(schedule);}

    public void delete(Long id) {
        scheduleRepository.deleteById(id);
    }
}
