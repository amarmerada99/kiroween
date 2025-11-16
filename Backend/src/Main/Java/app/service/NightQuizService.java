package app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.NightQuiz;
import app.repository.NightQuizRepository;

@Service
public class NightQuizService {
    private final NightQuizRepository nightQuizRepository;

    //constructor
    @Autowired
    public NightQuizService(NightQuizRepository nightQuizRepository) {
        this.nightQuizRepository = nightQuizRepository;
    }

    //retrieval
    public List<NightQuiz> getAllNightQuizzes() {
        return nightQuizRepository.findAll();
    }

    public NightQuiz addNightQuiz(NightQuiz nightQuiz) {
        return nightQuizRepository.save(nightQuiz);
    }

    public List<NightQuiz> getNightQuizzesByUserId(Integer userId) {
        return nightQuizRepository.findByUserId(userId);
    }

    public List<NightQuiz> getNightQuizByUserIdAndDate(Integer userId, LocalDate date) {
        return nightQuizRepository.findByUserIdAndDate(userId, date);
    }

    public List<NightQuiz> getNightQuizzesByUserIdAndDateRange(Integer userId, LocalDate start, LocalDate end) {
        return nightQuizRepository.findByUserIdAndDateBetween(userId, start, end);
    }

    public NightQuiz getNightQuizById(Integer nQuizId) {
        return nightQuizRepository.findById(nQuizId).orElse(null);
    }
}
