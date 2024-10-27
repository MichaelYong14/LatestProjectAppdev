package com.G1AppDevProj.Project.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.G1AppDevProj.Project.Entity.Quiz;


@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer> {
    // You can add custom query methods if needed
}
