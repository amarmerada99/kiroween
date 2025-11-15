package com.example.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.HoursLog;
import app.repository.HoursRepository;

@Service
public class HoursLogService {
    private final HoursRepository hoursRepository;

    //constructor
    @Autowired
    public HoursLogService(HoursRepository hoursRepository) {
        this.hoursRepository = hoursRepository;
    }

    //retrieval
    public List<HoursLog> getAllHoursLogs() {
        return hoursRepository.findAll();
    }

    public HoursLog addHoursLog(HoursLog hoursLog) {
        return hoursRepository.save(hoursLog);
    }

    public List<HoursLog> getHoursLogsByUserId(Integer userId) {
        return hoursRepository.findByUserId(userId);
    }

    public List<HoursLog> getHoursLogByUserIdAndDate(Integer userId, LocalDate date) {
        return hoursRepository.findByUserIdAndDate(userId, date);
    }

    public List<HoursLog> getHoursLogsByUserIdAndDateRange(Integer userId, LocalDate start, LocalDate end) {
        return hoursRepository.findByUserIdAndDateBetween(userId, start, end);
    }

    public Optional<HoursLog> getLatestHoursLogByUserId(Integer userId) {
        return hoursRepository.findTopByUserIdOrderByDateDesc(userId);
    }

    public HoursLog getHoursLogById(Integer hoursId) {
        return hoursRepository.findById(hoursId).orElse(null);
    }
}
