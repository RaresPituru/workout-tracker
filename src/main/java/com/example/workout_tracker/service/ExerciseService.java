package com.example.workout_tracker.service;

import com.example.workout_tracker.entities.Exercise;
import com.example.workout_tracker.exceptions.ResourceNotFoundException;
import com.example.workout_tracker.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    public Exercise getExerciseById(Long id) {
        return exerciseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercise not found"));
    }

    public Exercise createExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public void deleteExercise(Long id) {
        if(!exerciseRepository.existsById(id)){
            throw new ResourceNotFoundException("Exercise not found");
        }
        exerciseRepository.deleteById(id);
    }
}