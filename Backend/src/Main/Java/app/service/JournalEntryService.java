package app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.JournalEntry;
import app.repository.JournalEntryRepository;

@Service
public class JournalEntryService {
    private final JournalEntryRepository journalEntryRepository;

    //constructor
    @Autowired
    public JournalEntryService(JournalEntryRepository journalEntryRepository) {
        this.journalEntryRepository = journalEntryRepository;
    }

    //retrieval
    public List<JournalEntry> getAllJournalEntries() {
        return journalEntryRepository.findAll();
    }

    public JournalEntry addJournalEntry(JournalEntry journalEntry) {
        return journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getJournalEntriesByUserId(Integer userId) {
        return journalEntryRepository.findByUserId(userId);
    }

    public List<JournalEntry> getJournalEntryByUserIdAndDate(Integer userId, LocalDate date) {
        return journalEntryRepository.findByUserIdAndDate(userId, date);
    }

    public List<JournalEntry> getJournalEntriesByUserIdAndDateRange(Integer userId, LocalDate start, LocalDate end) {
        return journalEntryRepository.findByUserIdAndDateBetween(userId, start, end);
    }

    public JournalEntry getJournalEntryById(Integer entryId) {
        return journalEntryRepository.findById(entryId).orElse(null);
    }
}
