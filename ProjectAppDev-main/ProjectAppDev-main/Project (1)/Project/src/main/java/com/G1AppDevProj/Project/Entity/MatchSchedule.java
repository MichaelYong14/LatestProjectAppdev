package com.G1AppDevProj.Project.Entity;
import jakarta.persistence.*;

@Entity
public class MatchSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matchId")
    private int matchId;

    @ManyToOne
    @JoinColumn(name = "tutor_sched_id", nullable = false)
    private TutorSchedule tutorSchedule;

    @ManyToOne
    @JoinColumn(name = "student_sched_id", nullable = false)
    private StudentSchedule studentSchedule;

    // Getters and Setters
    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public TutorSchedule getTutorSchedule() {
        return tutorSchedule;
    }

    public void setTutorSchedule(TutorSchedule tutorSchedule) {
        this.tutorSchedule = tutorSchedule;
    }

    public StudentSchedule getStudentSchedule() {
        return studentSchedule;
    }

    public void setStudentSchedule(StudentSchedule studentSchedule) {
        this.studentSchedule = studentSchedule;
    }

    // Method to check if schedules match
    public boolean schedulesMatch() {
        return tutorSchedule.getSchedule().equals(studentSchedule.getSchedule());
    }
}
