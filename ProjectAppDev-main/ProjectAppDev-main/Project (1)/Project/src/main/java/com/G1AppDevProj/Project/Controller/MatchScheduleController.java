package com.G1AppDevProj.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.G1AppDevProj.Project.Entity.MatchSchedule;
import com.G1AppDevProj.Project.Service.MatchScheduleService;

import java.util.List;

@RestController
@RequestMapping("/api/match-schedules")
public class MatchScheduleController {

    @Autowired
    private MatchScheduleService matchScheduleService;

    @GetMapping
    public List<MatchSchedule> getAllMatchSchedules() {
        return matchScheduleService.getAllMatchSchedules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchSchedule> getMatchScheduleById(@PathVariable int id) {
        return matchScheduleService.getMatchScheduleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MatchSchedule createMatchSchedule(@RequestBody MatchSchedule matchSchedule) {
        return matchScheduleService.saveMatchSchedule(matchSchedule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatchSchedule(@PathVariable int id) {
        matchScheduleService.deleteMatchSchedule(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/check-match/{tutorSchedId}/{studentSchedId}")
    public ResponseEntity<Boolean> checkIfSchedulesMatch(@PathVariable int tutorSchedId, @PathVariable int studentSchedId) {
        boolean match = matchScheduleService.schedulesMatch(tutorSchedId, studentSchedId);
        return ResponseEntity.ok(match);
    }
}

