package com.G1AppDevProj.Project.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.G1AppDevProj.Project.Entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
     // Method to find a student by email
     Student findByEmail(String email);

     // Method to find a student by username and password
     Optional<Student> findByUsernameAndPassword(String username, String password);

}
