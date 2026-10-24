package com.example.workout_tracker.dto;

public class ExerciseEntryResponse {
    Long id;
    int sets;
    int reps;
    double weight;
    Long workoutSessionId;
    Long exerciseId;
    String exerciseName;

    public ExerciseEntryResponse(Long id, int sets, int reps, double weight, Long workoutSessionId, Long exerciseId, String exerciseName) {
        this.id = id;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.workoutSessionId = workoutSessionId;
        this.exerciseId = exerciseId;
        this.exerciseName = exerciseName;
    }

    public Long getId() {
        return id;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    public double getWeight() {
        return weight;
    }

    public Long getWorkoutSessionId() {
        return workoutSessionId;
    }

    public Long getExerciseId() {
        return exerciseId;
    }

    public String getExerciseName() {
        return exerciseName;
    }
}
