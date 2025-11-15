package app.repository;
import app.model.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;
 
import java.time.LocalDate;
import java.util.List;

public interface JournalEntryRepository extends JpaRepository<JournalEntry, Integer>{
    List<JournalEntry> findByUserId(int userId);
    List<JournalEntry> findByUserIdAndDate(int userId, LocalDate date);
    List<JournalEntry> findByUserIdAndDateBetween(int userId, LocalDate start, LocalDate end);
}
