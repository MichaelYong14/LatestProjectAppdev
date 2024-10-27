package com.G1AppDevProj.Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.G1AppDevProj.Project.Entity.TutorSchedule;

@Repository
public interface TutorScheduleRepository extends JpaRepository<TutorSchedule, Integer> {
}

