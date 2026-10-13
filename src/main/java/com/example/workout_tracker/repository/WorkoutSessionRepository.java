package com.example.workout_tracker.repository;

import com.example.workout_tracker.entities.WorkoutSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutSessionRepository extends JpaRepository<WorkoutSession,Long> {
}
