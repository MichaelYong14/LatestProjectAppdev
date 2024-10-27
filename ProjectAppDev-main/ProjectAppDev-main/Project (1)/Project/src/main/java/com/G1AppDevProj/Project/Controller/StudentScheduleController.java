package com.G1AppDevProj.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.G1AppDevProj.Project.Entity.StudentSchedule;
import com.G1AppDevProj.Project.Service.StudentScheduleService;

import java.util.List;

@RestController
@RequestMapping("/api/student-schedules")
public class StudentScheduleController {

    @Autowired
    private StudentScheduleService studentScheduleService;

    @GetMapping
    public List<StudentSchedule> getAllStudentSchedules() {
        return studentScheduleService.getAllStudentSchedules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentSchedule> getStudentScheduleById(@PathVariable int id) {
        return studentScheduleService.getStudentScheduleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public StudentSchedule createStudentSchedule(@RequestBody StudentSchedule studentSchedule) {
        return studentScheduleService.saveStudentSchedule(studentSchedule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentSchedule(@PathVariable int id) {
        studentScheduleService.deleteStudentSchedule(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<StudentSchedule> selectSchedule(@PathVariable int id) {
        return ResponseEntity.ok(studentScheduleService.selectSchedule(id));
    }
}

