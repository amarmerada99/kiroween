package app.service;


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

import app.model.NightQuiz;
import app.repository.NightQuizRepository;

public class NightQuizServiceTest {

    @Mock
    private NightQuizRepository nightQuizRepository;

    @InjectMocks
    private NightQuizService nightQuizService;

    private NightQuiz testQuiz;
    private LocalDate testDate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        testDate = LocalDate.of(2024, 1, 15);
        testQuiz = new NightQuiz(1, 1, testDate.toString(), 8, 22);
    }

    @Test
    public void testGetAllNightQuizzes() {
        List<NightQuiz> quizzes = Arrays.asList(testQuiz, new NightQuiz(2, 1, "2024-01-16", 7, 23));
        when(nightQuizRepository.findAll()).thenReturn(quizzes);

        List<NightQuiz> result = nightQuizService.getAllNightQuizzes();

        assertEquals(2, result.size());
        verify(nightQuizRepository, times(1)).findAll();
    }

    @Test
    public void testAddNightQuiz() {
        when(nightQuizRepository.save(testQuiz)).thenReturn(testQuiz);

        NightQuiz result = nightQuizService.addNightQuiz(testQuiz);

        assertNotNull(result);
        assertEquals(8, result.getProductivity());
        verify(nightQuizRepository, times(1)).save(testQuiz);
    }

    @Test
    public void testGetNightQuizzesByUserId() {
        List<NightQuiz> quizzes = Arrays.asList(testQuiz);
        when(nightQuizRepository.findByUserId(1)).thenReturn(quizzes);

        List<NightQuiz> result = nightQuizService.getNightQuizzesByUserId(1);

        assertEquals(1, result.size());
        assertEquals(1, result.get(0).getUserId());
        verify(nightQuizRepository, times(1)).findByUserId(1);
    }

    @Test
    public void testGetNightQuizByUserIdAndDate() {
        List<NightQuiz> quizzes = Arrays.asList(testQuiz);
        when(nightQuizRepository.findByUserIdAndDate(1, testDate)).thenReturn(quizzes);

        List<NightQuiz> result = nightQuizService.getNightQuizByUserIdAndDate(1, testDate);

        assertEquals(1, result.size());
        verify(nightQuizRepository, times(1)).findByUserIdAndDate(1, testDate);
    }

    @Test
    public void testGetNightQuizzesByUserIdAndDateRange() {
        LocalDate start = LocalDate.of(2024, 1, 1);
        LocalDate end = LocalDate.of(2024, 1, 31);
        List<NightQuiz> quizzes = Arrays.asList(testQuiz);
        when(nightQuizRepository.findByUserIdAndDateBetween(1, start, end)).thenReturn(quizzes);

        List<NightQuiz> result = nightQuizService.getNightQuizzesByUserIdAndDateRange(1, start, end);

        assertEquals(1, result.size());
        verify(nightQuizRepository, times(1)).findByUserIdAndDateBetween(1, start, end);
    }

    @Test
    public void testGetNightQuizById() {
        when(nightQuizRepository.findById(1)).thenReturn(Optional.of(testQuiz));

        NightQuiz result = nightQuizService.getNightQuizById(1);

        assertNotNull(result);
        assertEquals(1, result.getNQuizId());
        verify(nightQuizRepository, times(1)).findById(1);
    }

    @Test
    public void testGetNightQuizByIdNotFound() {
        when(nightQuizRepository.findById(999)).thenReturn(Optional.empty());

        NightQuiz result = nightQuizService.getNightQuizById(999);

        assertNull(result);
        verify(nightQuizRepository, times(1)).findById(999);
    }
}
