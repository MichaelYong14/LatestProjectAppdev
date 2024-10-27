package com.G1AppDevProj.Project.Service;
import com.G1AppDevProj.Project.Entity.TutorSchedule;
import com.G1AppDevProj.Project.Repository.TutorScheduleRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorScheduleService {

    @Autowired
    private TutorScheduleRepository tutorScheduleRepository;

    public List<TutorSchedule> getAllTutorSchedules() {
        return tutorScheduleRepository.findAll();
    }

    public Optional<TutorSchedule> getTutorScheduleById(int tutorSchedId) {
        return tutorScheduleRepository.findById(tutorSchedId);
    }

    public TutorSchedule saveTutorSchedule(TutorSchedule tutorSchedule) {
        return tutorScheduleRepository.save(tutorSchedule);
    }

    public void deleteTutorSchedule(int tutorSchedId) {
        tutorScheduleRepository.deleteById(tutorSchedId);
    }

    // Method to select a schedule by ID
    public TutorSchedule selectSchedule(int tutorSchedId) {
        return tutorScheduleRepository.findById(tutorSchedId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid tutor schedule ID"));
    }
}
