package com.example.workout_tracker.service;

import com.example.workout_tracker.dto.CreateExerciseRequest;
import com.example.workout_tracker.dto.ExerciseResponse;
import com.example.workout_tracker.entities.Exercise;
import com.example.workout_tracker.exceptions.ResourceNotFoundException;
import com.example.workout_tracker.mapper.ExerciseMapper;
import com.example.workout_tracker.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<ExerciseResponse> getAllExercises() {

        List<Exercise> exercises = exerciseRepository.findAll();
        return exercises.stream().map(ExerciseMapper::toResponse).toList();
    }

    public ExerciseResponse getExerciseById(Long id) {
        Exercise exercise = exerciseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exercise not found"));
        return ExerciseMapper.toResponse(exercise);
    }

    public ExerciseResponse createExercise(CreateExerciseRequest request) {

        Exercise exercise = ExerciseMapper.toEntity(request);
        Exercise saved = exerciseRepository.save(exercise);
        return ExerciseMapper.toResponse(saved);
    }

    public void deleteExercise(Long id) {
        if(!exerciseRepository.existsById(id)){
            throw new ResourceNotFoundException("Exercise not found");
        }
        exerciseRepository.deleteById(id);
    }
}