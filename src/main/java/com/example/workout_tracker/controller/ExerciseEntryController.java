package com.example.workout_tracker.controller;

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
    public ExerciseEntry getById(@PathVariable Long id){
        return exerciseEntryService.getExerciseEntryById(id);
    }
    @PostMapping
    public ExerciseEntry create(@RequestParam Long workoutId,@RequestParam Long exerciseId
            ,@RequestBody ExerciseEntry exerciseEntry){
        return exerciseEntryService.createExerciseEntry(workoutId,exerciseId,exerciseEntry);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        exerciseEntryService.deleteExerciseEntry(id);
    }

    @PutMapping("/{id}")
    public ExerciseEntry update(@PathVariable Long id, @RequestBody ExerciseEntry exerciseEntry) {
        return exerciseEntryService.updateExerciseEntry(id, exerciseEntry);
    }
}

