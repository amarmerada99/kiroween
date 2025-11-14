package app.repository;
import app.model.morningQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
 
import java.time.LocalDate;
import java.util.List;

public interface morningQuizRepository extends JpaRepository<MorningQuiz, Integer>{
    List<MorningQuiz> findByUserId(int userId);
    List<MorningQuiz> findByUserIdAnadDate(int userId, LocalDate date);
    List <MorningQuiz> findByUserIdAndDateBetween(int userId, LocalDate start, LocalDate end);
}