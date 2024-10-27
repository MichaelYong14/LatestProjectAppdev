package com.G1AppDevProj.Project.Entity;

import jakarta.persistence.*;

@Entity
public class TutorSchedule {

    @Id
    @Column(name = "tutorSchedId")
    private int tutorSchedId; // Manually assigned ID

    @Column(nullable = false)
    private String schedule; // E.g., "MWF" or "TTH"

    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)
    private Tutor tutor;

    // Getters and Setters
    public int getTutorSchedId() {
        return tutorSchedId;
    }

    public void setTutorSchedId(int tutorSchedId) {
        this.tutorSchedId = tutorSchedId;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    // Method to select a schedule
    public void selectSchedule(int tutorSchedId) {
        this.tutorSchedId = tutorSchedId;
    }
}
