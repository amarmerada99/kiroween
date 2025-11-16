package app.repository;
import app.model.NightQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
 
import java.time.LocalDate;
import java.util.List;

public interface NightQuizRepository extends JpaRepository<NightQuiz, Integer>{
    List<NightQuiz> findByUserId(int userId);
    List<NightQuiz> findByUserIdAndDate(int userId, LocalDate date);
    List<NightQuiz> findByUserIdAndDateBetween(int userId, LocalDate start, LocalDate end);
}