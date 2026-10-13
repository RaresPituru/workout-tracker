package com.example.workout_tracker.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class ExerciseEntry {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private int sets;
    private int reps;
    private double weight;


    @ManyToOne
    @JoinColumn(name = "workout_session_id")
    @JsonBackReference
    private WorkoutSession workoutSession;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    public int getSets() {
        return sets;
    }
    public int getReps() {
        return reps;
    }
    public double getWeight() {
        return weight;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public WorkoutSession getWorkoutSession() {
        return workoutSession;
    }

    public void setWorkoutSession(WorkoutSession workoutSession) {
        this.workoutSession = workoutSession;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
