package com.example.workout_tracker.controller;

import com.example.workout_tracker.dto.CreateExerciseRequest;
import com.example.workout_tracker.dto.ExerciseResponse;
import com.example.workout_tracker.entities.Exercise;
import com.example.workout_tracker.service.ExerciseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping
    public List<ExerciseResponse> getAll() {
        return exerciseService.getAllExercises();
    }

    @GetMapping("/{id}")
    public ExerciseResponse getById(@PathVariable Long id) {
        return exerciseService.getExerciseById(id);
    }

    @PostMapping
    public ExerciseResponse create(@RequestBody CreateExerciseRequest exercise) {
        return exerciseService.createExercise(exercise);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        exerciseService.deleteExercise(id);
    }
}