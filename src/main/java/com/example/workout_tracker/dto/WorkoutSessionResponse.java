package com.example.workout_tracker.dto;

import java.time.LocalDate;

public class WorkoutSessionResponse {
    Long id;
    LocalDate date;
    Long userId;

    public WorkoutSessionResponse(Long id, LocalDate date, Long userId) {
        this.id = id;
        this.date = date;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getUserId() {
        return userId;
    }
}
