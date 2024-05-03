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

    public void save(Schedule schedule) {
        Date releaseDate = schedule.getMovie().getReleaseDate();
        Date startTime = schedule.getTimeStart();

        if (releaseDate != null && startTime != null && releaseDate.after(startTime)) {
            throw new IllegalArgumentException("La fecha de lanzamiento debe ser anterior al inicio del horario de proyección");
        }

        if(releaseDate == null){
            throw new IllegalArgumentException("La fecha de lanzamiento es nula o no existe la película");
        }

        scheduleRepository.save(schedule);
    }

    public void delete(Long id) {
        scheduleRepository.deleteById(id);
    }
}
