package com.G1AppDevProj.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.G1AppDevProj.Project.Entity.TutorSchedule;
import com.G1AppDevProj.Project.Service.TutorScheduleService;

import java.util.List;

@RestController
@RequestMapping("/api/tutor-schedules")
public class TutorScheduleController {

    @Autowired
    private TutorScheduleService tutorScheduleService;

    @GetMapping
    public List<TutorSchedule> getAllTutorSchedules() {
        return tutorScheduleService.getAllTutorSchedules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TutorSchedule> getTutorScheduleById(@PathVariable int id) {
        return tutorScheduleService.getTutorScheduleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/select")
    public TutorSchedule createTutorSchedule(@RequestBody TutorSchedule tutorSchedule) {
        return tutorScheduleService.saveTutorSchedule(tutorSchedule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTutorSchedule(@PathVariable int id) {
        tutorScheduleService.deleteTutorSchedule(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<TutorSchedule> selectSchedule(@PathVariable int id) {
        return ResponseEntity.ok(tutorScheduleService.selectSchedule(id));
    }
}

