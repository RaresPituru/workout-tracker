package com.example.workout_tracker.repository;

import com.example.workout_tracker.entities.ExerciseEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseEntryRepository extends JpaRepository<ExerciseEntry,Long> {
}
