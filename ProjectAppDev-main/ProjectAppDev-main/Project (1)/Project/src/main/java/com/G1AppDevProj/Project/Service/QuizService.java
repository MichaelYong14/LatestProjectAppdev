package com.G1AppDevProj.Project.Service;


import com.G1AppDevProj.Project.Entity.Quiz;
import com.G1AppDevProj.Project.Repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    private final QuizRepo quizRepository;

    @Autowired
    public QuizService(QuizRepo quizRepository) {
        this.quizRepository = quizRepository;
    }

    // Create
    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    // Find by ID
    public Optional<Quiz> findQuizById(int id) {
        return quizRepository.findById(id);
    }

    // Find All
    public List<Quiz> findAllQuizzes() {
        return quizRepository.findAll();
    }

    // Update
    public Quiz updateQuiz(int id, Quiz updatedQuiz) {
        Optional<Quiz> existingQuiz = quizRepository.findById(id);
        if (existingQuiz.isPresent()) {
            Quiz quiz = existingQuiz.get();
            quiz.setTitle(updatedQuiz.getTitle());
            return quizRepository.save(quiz);
        }
        return null;
    }

    // Delete
    public boolean deleteQuiz(int id) {
        if (quizRepository.existsById(id)) {
            quizRepository.deleteById(id);
            return true;
        }
        return false;
    }
}