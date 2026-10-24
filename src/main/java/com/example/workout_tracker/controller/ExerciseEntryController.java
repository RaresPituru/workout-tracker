package com.example.workout_tracker.controller;

import com.example.workout_tracker.dto.CreateExerciseEntryRequest;
import com.example.workout_tracker.dto.CreateExerciseRequest;
import com.example.workout_tracker.dto.ExerciseEntryResponse;
import com.example.workout_tracker.entities.ExerciseEntry;
import com.example.workout_tracker.service.ExerciseEntryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entries")
public class ExerciseEntryController {
    private final ExerciseEntryService exerciseEntryService;

    public ExerciseEntryController (ExerciseEntryService exerciseEntryService){
        this.exerciseEntryService = exerciseEntryService;
    }

    @GetMapping("/{id}")
    public ExerciseEntryResponse getById(@PathVariable Long id){
        return exerciseEntryService.getExerciseEntryById(id);
    }
    @PostMapping
    public ExerciseEntryResponse create(@RequestParam Long workoutId,@RequestParam Long exerciseId
            ,@RequestBody CreateExerciseEntryRequest exerciseEntry){
        return exerciseEntryService.createExerciseEntry(workoutId,exerciseId,exerciseEntry);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        exerciseEntryService.deleteExerciseEntry(id);
    }

    @PutMapping("/{id}")
    public ExerciseEntryResponse update(@PathVariable Long id, @RequestBody CreateExerciseEntryRequest exerciseEntry) {
        return exerciseEntryService.updateExerciseEntry(id, exerciseEntry);
    }
}

