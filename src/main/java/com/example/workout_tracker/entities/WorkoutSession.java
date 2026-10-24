package com.example.workout_tracker.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
public class WorkoutSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")

    private User user;

    @OneToMany(mappedBy = "workoutSession", cascade = CascadeType.REMOVE)

    private List<ExerciseEntry> exerciseEntries = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ExerciseEntry> getExerciseEntries() {
        return exerciseEntries;
    }

    public void setExerciseEntries(List<ExerciseEntry> exerciseEntries) {
        this.exerciseEntries = exerciseEntries;
    }
}
