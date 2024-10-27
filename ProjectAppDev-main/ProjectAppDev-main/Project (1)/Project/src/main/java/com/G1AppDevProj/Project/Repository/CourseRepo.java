package com.G1AppDevProj.Project.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.G1AppDevProj.Project.Entity.Course;


@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {
    // You can add custom query methods if needed
}
