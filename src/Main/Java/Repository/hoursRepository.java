package app.repository;
import app.model.HoursLog;
import org.springframework.data.jpa.repository.JpaRepository;
 
import java.time.LocalDate;
import java.util.List;

public interface hoursRepository extends JpaRepository<HoursLog, Integer>{
    List<Hours> findByUserId(int userId);
    List <Hours> findByUserIdAndDate(int userId, LocalDate date );
    List<Hours> findByUserIdAndDateBetween(int userId, LocalDate start, LocalDate end);
    Optional<Hours> findTopByUserIdOrderByDateDesc(int userId);
}