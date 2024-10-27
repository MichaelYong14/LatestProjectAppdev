package com.G1AppDevProj.Project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.G1AppDevProj.Project.Entity.StudentSchedule;
import com.G1AppDevProj.Project.Repository.StudentScheduleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentScheduleService {

    @Autowired
    private StudentScheduleRepository studentScheduleRepository;

    public List<StudentSchedule> getAllStudentSchedules() {
        return studentScheduleRepository.findAll();
    }

    public Optional<StudentSchedule> getStudentScheduleById(int studentSchedId) {
        return studentScheduleRepository.findById(studentSchedId);
    }

    public StudentSchedule saveStudentSchedule(StudentSchedule studentSchedule) {
        return studentScheduleRepository.save(studentSchedule);
    }

    public void deleteStudentSchedule(int studentSchedId) {
        studentScheduleRepository.deleteById(studentSchedId);
    }

    // Method to select a schedule by ID
    public StudentSchedule selectSchedule(int studentSchedId) {
        return studentScheduleRepository.findById(studentSchedId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student schedule ID"));
    }
}
