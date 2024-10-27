package com.G1AppDevProj.Project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.G1AppDevProj.Project.Entity.MatchSchedule;
import com.G1AppDevProj.Project.Entity.StudentSchedule;
import com.G1AppDevProj.Project.Entity.TutorSchedule;
import com.G1AppDevProj.Project.Repository.MatchScheduleRepository;
import com.G1AppDevProj.Project.Repository.StudentScheduleRepository;
import com.G1AppDevProj.Project.Repository.TutorScheduleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MatchScheduleService {

    @Autowired
    private MatchScheduleRepository matchScheduleRepository;

    @Autowired
    private TutorScheduleRepository tutorScheduleRepository;

    @Autowired
    private StudentScheduleRepository studentScheduleRepository;

    public List<MatchSchedule> getAllMatchSchedules() {
        return matchScheduleRepository.findAll();
    }

    public Optional<MatchSchedule> getMatchScheduleById(int matchId) {
        return matchScheduleRepository.findById(matchId);
    }

    public MatchSchedule saveMatchSchedule(MatchSchedule matchSchedule) {
        return matchScheduleRepository.save(matchSchedule);
    }

    public void deleteMatchSchedule(int matchId) {
        matchScheduleRepository.deleteById(matchId);
    }

    // Method to check if schedules match
    public boolean schedulesMatch(int tutorSchedId, int studentSchedId) {
        Optional<TutorSchedule> tutorSchedule = tutorScheduleRepository.findById(tutorSchedId);
        Optional<StudentSchedule> studentSchedule = studentScheduleRepository.findById(studentSchedId);

    // Check if both schedules exist and if they match
        if (tutorSchedule.isPresent() && studentSchedule.isPresent()) {
            return tutorSchedule.get().getSchedule().equals(studentSchedule.get().getSchedule());
        }

        return false; // Return false if either schedule is missing
    }
}

