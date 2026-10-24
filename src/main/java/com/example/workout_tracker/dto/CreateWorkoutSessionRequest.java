package com.example.workout_tracker.dto;

import java.time.LocalDate;

public class CreateWorkoutSessionRequest {
    LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
