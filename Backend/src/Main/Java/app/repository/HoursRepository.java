package app.repository;

import app.model.HoursLog;
import org.springframework.data.jpa.repository.JpaRepository;
 
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface HoursRepository extends JpaRepository<HoursLog, Integer>{
    List<HoursLog> findByUserId(int userId);
    List <HoursLog> findByUserIdAndDate(int userId, LocalDate date );
    List<HoursLog> findByUserIdAndDateBetween(int userId, LocalDate start, LocalDate end);
    Optional<HoursLog> findTopByUserIdOrderByDateDesc(int userId);
}