package com.G1AppDevProj.Project.Controller;

import com.G1AppDevProj.Project.Entity.Student;
import com.G1AppDevProj.Project.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Register (Create) Student
    @PostMapping("/register")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.registerStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    // Login Student
    @PostMapping("/login")
    public ResponseEntity<Student> login(@RequestParam String username, @RequestParam String password) {
        Optional<Student> student = studentService.loginStudent(username, password);
        return student.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    // Get Student by ID
    @GetMapping("/findStudent/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Optional<Student> student = studentService.findStudentById(id);
        return student.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Get All Students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.findAllStudents();
        return ResponseEntity.ok(students);
    }

    // Update Student
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        Student student = studentService.updateStudent(id, updatedStudent);
        if (student != null) {
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Delete Student
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        if (studentService.deleteStudent(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
