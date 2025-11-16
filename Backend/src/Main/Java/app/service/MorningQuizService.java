package app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.MorningQuiz;
import app.repository.MorningQuizRepository;

@Service
public class MorningQuizService {
    private final MorningQuizRepository morningQuizRepository;

    //constructor
    @Autowired
    public MorningQuizService(MorningQuizRepository morningQuizRepository) {
        this.morningQuizRepository = morningQuizRepository;
    }

    //retrieval
    public List<MorningQuiz> getAllMorningQuizzes() {
        return morningQuizRepository.findAll();
    }

    public MorningQuiz addMorningQuiz(MorningQuiz morningQuiz) {
        return morningQuizRepository.save(morningQuiz);
    }

    public List<MorningQuiz> getMorningQuizzesByUserId(Integer userId) {
        return morningQuizRepository.findByUserId(userId);
    }

    public List<MorningQuiz> getMorningQuizByUserIdAndDate(Integer userId, LocalDate date) {
        return morningQuizRepository.findByUserIdAnadDate(userId, date);
    }

    public List<MorningQuiz> getMorningQuizzesByUserIdAndDateRange(Integer userId, LocalDate start, LocalDate end) {
        return morningQuizRepository.findByUserIdAndDateBetween(userId, start, end);
    }

    public MorningQuiz getMorningQuizById(Integer mQuizId) {
        return morningQuizRepository.findById(mQuizId).orElse(null);
    }
}
