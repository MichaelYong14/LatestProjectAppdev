package com.G1AppDevProj.Project.Controller;

import com.G1AppDevProj.Project.Entity.Tutor;
import com.G1AppDevProj.Project.Service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tutors")
public class TutorController {

    private final TutorService tutorService;

    @Autowired
    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    // Register (Create) Tutor
    @PostMapping("/register")
    public ResponseEntity<Tutor> createTutor(@RequestBody Tutor tutor) {
        Tutor createdTutor = tutorService.registerTutor(tutor);
        return new ResponseEntity<>(createdTutor, HttpStatus.CREATED);
    }

    // Login Tutor
    @PostMapping("/login")
    public ResponseEntity<Tutor> login(@RequestParam String username, @RequestParam String password) {
        Optional<Tutor> tutor = tutorService.loginTutor(username, password);
        return tutor.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    // Get Tutor by ID
    @GetMapping("/findTutor/{id}")
    public ResponseEntity<Tutor> getTutorById(@PathVariable int id) {
        Optional<Tutor> tutor = tutorService.findTutorById(id);
        return tutor.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Get All Tutors
    @GetMapping
    public ResponseEntity<List<Tutor>> getAllTutors() {
        List<Tutor> tutors = tutorService.findAllTutors();
        return ResponseEntity.ok(tutors);
    }

    // Update Tutor
    @PutMapping("/update/{id}")
    public ResponseEntity<Tutor> updateTutor(@PathVariable int id, @RequestBody Tutor updatedTutor) {
        Tutor tutor = tutorService.updateTutor(id, updatedTutor);
        if (tutor != null) {
            return ResponseEntity.ok(tutor);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Delete Tutor
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTutor(@PathVariable int id) {
        if (tutorService.deleteTutor(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
