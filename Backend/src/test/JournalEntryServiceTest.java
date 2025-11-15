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

import app.model.JournalEntry;
import app.repository.JournalEntryRepository;

public class JournalEntryServiceTest {

    @Mock
    private JournalEntryRepository journalEntryRepository;

    @InjectMocks
    private JournalEntryService journalEntryService;

    private JournalEntry testEntry;
    private LocalDate testDate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        testDate = LocalDate.of(2024, 1, 15);
        testEntry = new JournalEntry(1, 1, testDate.toString(), "I had a dream about flying");
    }

    @Test
    public void testGetAllJournalEntries() {
        List<JournalEntry> entries = Arrays.asList(testEntry, new JournalEntry(2, 1, "2024-01-16", "Another dream"));
        when(journalEntryRepository.findAll()).thenReturn(entries);

        List<JournalEntry> result = journalEntryService.getAllJournalEntries();

        assertEquals(2, result.size());
        verify(journalEntryRepository, times(1)).findAll();
    }

    @Test
    public void testAddJournalEntry() {
        when(journalEntryRepository.save(testEntry)).thenReturn(testEntry);

        JournalEntry result = journalEntryService.addJournalEntry(testEntry);

        assertNotNull(result);
        assertEquals("I had a dream about flying", result.getTextPayload());
        verify(journalEntryRepository, times(1)).save(testEntry);
    }

    @Test
    public void testGetJournalEntriesByUserId() {
        List<JournalEntry> entries = Arrays.asList(testEntry);
        when(journalEntryRepository.findByUserId(1)).thenReturn(entries);

        List<JournalEntry> result = journalEntryService.getJournalEntriesByUserId(1);

        assertEquals(1, result.size());
        assertEquals(1, result.get(0).getUserId());
        verify(journalEntryRepository, times(1)).findByUserId(1);
    }

    @Test
    public void testGetJournalEntryByUserIdAndDate() {
        List<JournalEntry> entries = Arrays.asList(testEntry);
        when(journalEntryRepository.findByUserIdAndDate(1, testDate)).thenReturn(entries);

        List<JournalEntry> result = journalEntryService.getJournalEntryByUserIdAndDate(1, testDate);

        assertEquals(1, result.size());
        verify(journalEntryRepository, times(1)).findByUserIdAndDate(1, testDate);
    }

    @Test
    public void testGetJournalEntriesByUserIdAndDateRange() {
        LocalDate start = LocalDate.of(2024, 1, 1);
        LocalDate end = LocalDate.of(2024, 1, 31);
        List<JournalEntry> entries = Arrays.asList(testEntry);
        when(journalEntryRepository.findByUserIdAndDateBetween(1, start, end)).thenReturn(entries);

        List<JournalEntry> result = journalEntryService.getJournalEntriesByUserIdAndDateRange(1, start, end);

        assertEquals(1, result.size());
        verify(journalEntryRepository, times(1)).findByUserIdAndDateBetween(1, start, end);
    }

    @Test
    public void testGetJournalEntryById() {
        when(journalEntryRepository.findById(1)).thenReturn(Optional.of(testEntry));

        JournalEntry result = journalEntryService.getJournalEntryById(1);

        assertNotNull(result);
        assertEquals(1, result.getEntryId());
        verify(journalEntryRepository, times(1)).findById(1);
    }

    @Test
    public void testGetJournalEntryByIdNotFound() {
        when(journalEntryRepository.findById(999)).thenReturn(Optional.empty());

        JournalEntry result = journalEntryService.getJournalEntryById(999);

        assertNull(result);
        verify(journalEntryRepository, times(1)).findById(999);
    }
}
