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

import app.model.MorningQuiz;
import app.repository.MorningQuizRepository;

public class MorningQuizServiceTest {

    @Mock
    private MorningQuizRepository morningQuizRepository;

    @InjectMocks
    private MorningQuizService morningQuizService;

    private MorningQuiz testQuiz;
    private LocalDate testDate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        testDate = LocalDate.of(2024, 1, 15);
        testQuiz = new MorningQuiz(1, 1, testDate.toString(), 8);
    }

    @Test
    public void testGetAllMorningQuizzes() {
        List<MorningQuiz> quizzes = Arrays.asList(testQuiz, new MorningQuiz(2, 1, "2024-01-16", 7));
        when(morningQuizRepository.findAll()).thenReturn(quizzes);

        List<MorningQuiz> result = morningQuizService.getAllMorningQuizzes();

        assertEquals(2, result.size());
        verify(morningQuizRepository, times(1)).findAll();
    }

    @Test
    public void testAddMorningQuiz() {
        when(morningQuizRepository.save(testQuiz)).thenReturn(testQuiz);

        MorningQuiz result = morningQuizService.addMorningQuiz(testQuiz);

        assertNotNull(result);
        assertEquals(8, result.getSleepRating());
        verify(morningQuizRepository, times(1)).save(testQuiz);
    }

    @Test
    public void testGetMorningQuizzesByUserId() {
        List<MorningQuiz> quizzes = Arrays.asList(testQuiz);
        when(morningQuizRepository.findByUserId(1)).thenReturn(quizzes);

        List<MorningQuiz> result = morningQuizService.getMorningQuizzesByUserId(1);

        assertEquals(1, result.size());
        assertEquals(1, result.get(0).getUserId());
        verify(morningQuizRepository, times(1)).findByUserId(1);
    }

    @Test
    public void testGetMorningQuizByUserIdAndDate() {
        List<MorningQuiz> quizzes = Arrays.asList(testQuiz);
        when(morningQuizRepository.findByUserIdAnadDate(1, testDate)).thenReturn(quizzes);

        List<MorningQuiz> result = morningQuizService.getMorningQuizByUserIdAndDate(1, testDate);

        assertEquals(1, result.size());
        verify(morningQuizRepository, times(1)).findByUserIdAnadDate(1, testDate);
    }

    @Test
    public void testGetMorningQuizzesByUserIdAndDateRange() {
        LocalDate start = LocalDate.of(2024, 1, 1);
        LocalDate end = LocalDate.of(2024, 1, 31);
        List<MorningQuiz> quizzes = Arrays.asList(testQuiz);
        when(morningQuizRepository.findByUserIdAndDateBetween(1, start, end)).thenReturn(quizzes);

        List<MorningQuiz> result = morningQuizService.getMorningQuizzesByUserIdAndDateRange(1, start, end);

        assertEquals(1, result.size());
        verify(morningQuizRepository, times(1)).findByUserIdAndDateBetween(1, start, end);
    }

    @Test
    public void testGetMorningQuizById() {
        when(morningQuizRepository.findById(1)).thenReturn(Optional.of(testQuiz));

        MorningQuiz result = morningQuizService.getMorningQuizById(1);

        assertNotNull(result);
        assertEquals(1, result.getMQuizId());
        verify(morningQuizRepository, times(1)).findById(1);
    }

    @Test
    public void testGetMorningQuizByIdNotFound() {
        when(morningQuizRepository.findById(999)).thenReturn(Optional.empty());

        MorningQuiz result = morningQuizService.getMorningQuizById(999);

        assertNull(result);
        verify(morningQuizRepository, times(1)).findById(999);
    }
}
