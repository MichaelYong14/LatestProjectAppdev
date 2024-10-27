package com.G1AppDevProj.Project.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.G1AppDevProj.Project.Entity.Tutor;


@Repository
public interface TutorRepo extends JpaRepository<Tutor, Integer> {

    Optional<Tutor> findByUsernameAndPassword(String username, String password);
    // You can add custom query methods if needed
    
}
