package com.example.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import app.model.HoursLog;
import app.repository.HoursRepository;

public class HoursLogServiceTest {

    @Mock
    private HoursRepository hoursRepository;

    @InjectMocks
    private HoursLogService hoursLogService;

    private HoursLog testLog;
    private LocalDate testDate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        testDate = LocalDate.of(2024, 1, 15);
        testLog = new HoursLog(1, 1, testDate.toString(), 2200, 600, 8.0f);
    }

    @Test
    public void testGetAllHoursLogs() {
        List<HoursLog> logs = Arrays.asList(testLog, new HoursLog(2, 1, "2024-01-16", 2300, 700, 8.0f));
        when(hoursRepository.findAll()).thenReturn(logs);

        List<HoursLog> result = hoursLogService.getAllHoursLogs();

        assertEquals(2, result.size());
        verify(hoursRepository, times(1)).findAll();
    }

    @Test
    public void testAddHoursLog() {
        when(hoursRepository.save(testLog)).thenReturn(testLog);

        HoursLog result = hoursLogService.addHoursLog(testLog);

        assertNotNull(result);
        assertEquals(8.0f, result.getTotalHours());
        verify(hoursRepository, times(1)).save(testLog);
    }

    @Test
    public void testGetHoursLogsByUserId() {
        List<HoursLog> logs = Arrays.asList(testLog);
        when(hoursRepository.findByUserId(1)).thenReturn(logs);

        List<HoursLog> result = hoursLogService.getHoursLogsByUserId(1);

        assertEquals(1, result.size());
        assertEquals(1, result.get(0).getUserId());
        verify(hoursRepository, times(1)).findByUserId(1);
    }

    @Test
    public void testGetHoursLogByUserIdAndDate() {
        List<HoursLog> logs = Arrays.asList(testLog);
        when(hoursRepository.findByUserIdAndDate(1, testDate)).thenReturn(logs);

        List<HoursLog> result = hoursLogService.getHoursLogByUserIdAndDate(1, testDate);

        assertEquals(1, result.size());
        verify(hoursRepository, times(1)).findByUserIdAndDate(1, testDate);
    }

    @Test
    public void testGetHoursLogsByUserIdAndDateRange() {
        LocalDate start = LocalDate.of(2024, 1, 1);
        LocalDate end = LocalDate.of(2024, 1, 31);
        List<HoursLog> logs = Arrays.asList(testLog);
        when(hoursRepository.findByUserIdAndDateBetween(1, start, end)).thenReturn(logs);

        List<HoursLog> result = hoursLogService.getHoursLogsByUserIdAndDateRange(1, start, end);

        assertEquals(1, result.size());
        verify(hoursRepository, times(1)).findByUserIdAndDateBetween(1, start, end);
    }

    @Test
    public void testGetLatestHoursLogByUserId() {
        when(hoursRepository.findTopByUserIdOrderByDateDesc(1)).thenReturn(Optional.of(testLog));

        Optional<HoursLog> result = hoursLogService.getLatestHoursLogByUserId(1);

        assertTrue(result.isPresent());
        assertEquals(testLog, result.get());
        verify(hoursRepository, times(1)).findTopByUserIdOrderByDateDesc(1);
    }

    @Test
    public void testGetLatestHoursLogByUserIdNotFound() {
        when(hoursRepository.findTopByUserIdOrderByDateDesc(999)).thenReturn(Optional.empty());

        Optional<HoursLog> result = hoursLogService.getLatestHoursLogByUserId(999);

        assertFalse(result.isPresent());
        verify(hoursRepository, times(1)).findTopByUserIdOrderByDateDesc(999);
    }

    @Test
    public void testGetHoursLogById() {
        when(hoursRepository.findById(1)).thenReturn(Optional.of(testLog));

        HoursLog result = hoursLogService.getHoursLogById(1);

        assertNotNull(result);
        assertEquals(1, result.getHoursId());
        verify(hoursRepository, times(1)).findById(1);
    }

    @Test
    public void testGetHoursLogByIdNotFound() {
        when(hoursRepository.findById(999)).thenReturn(Optional.empty());

        HoursLog result = hoursLogService.getHoursLogById(999);

        assertNull(result);
        verify(hoursRepository, times(1)).findById(999);
    }
}
