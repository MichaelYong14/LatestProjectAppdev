package com.G1AppDevProj.Project.Entity;

import jakarta.persistence.*;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")  // Column label for the primary key
    private int topicID;

    @Column(name = "topic_name", nullable = false)  // Non-nullable column
    private String topicName;

    @Column(name = "description")  // Optional description field
    private String description;

    // Many topics belong to one course
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)  // Foreign key column
    private Course course;

    // Constructors
    public Topic() {
    }

    public Topic(String topicName, String description, Course course) {
        this.topicName = topicName;
        this.description = description;
        this.course = course;
    }

    // Getters and Setters
    public int getTopicID() {
        return topicID;
    }

    public void setTopicID(int topicID) {
        this.topicID = topicID;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}