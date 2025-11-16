package app.repository;
import app.model.MorningQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
 
import java.time.LocalDate;
import java.util.List;

public interface MorningQuizRepository extends JpaRepository<MorningQuiz, Integer>{
    List<MorningQuiz> findByUserId(int userId);
    List<MorningQuiz> findByUserIdAnadDate(int userId, LocalDate date);
    List<MorningQuiz> findByUserIdAndDateBetween(int userId, LocalDate start, LocalDate end);
}