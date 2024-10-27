package com.G1AppDevProj.Project.Entity;

//import jakarta.persistence.ManyToOne;
import jakarta.persistence.*;

@Entity
public class StudentSchedule {

    @Id
    @Column(name = "studentSchedId")
    private int studentSchedId; // Manually assigned ID

    @Column(name = "schedule", nullable = false)
    private String schedule; // E.g., "MWF" or "TTH"

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    // Getters and Setters
    public int getStudentSchedId() {
        return studentSchedId;
    }

    public void setStudentSchedId(int studentSchedId) {
        this.studentSchedId = studentSchedId;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    // Method to select a schedule
    public void selectSchedule(int studentSchedId) {
        this.studentSchedId = studentSchedId;
    }
}