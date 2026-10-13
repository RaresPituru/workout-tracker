package com.example.workout_tracker.controller;

import com.example.workout_tracker.entities.WorkoutSession;
import com.example.workout_tracker.service.WorkoutSessionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class WorkoutSessionController {
    private final WorkoutSessionService workoutSessionService;

    public WorkoutSessionController(WorkoutSessionService workoutSessionService) {
        this.workoutSessionService = workoutSessionService;
    }

    @GetMapping
    public List<WorkoutSession> getAll(){
        return workoutSessionService.getAllWorkouts();
    }
    @GetMapping("/{id}")
    public WorkoutSession getById(@PathVariable Long id){
        return workoutSessionService.getWorkoutById(id);
    }
    @PostMapping
    public WorkoutSession create(@RequestParam Long userId,@RequestBody WorkoutSession session){
        return workoutSessionService.createWorkout(userId,session);
    }
    @PutMapping("/{id}")
    public WorkoutSession update(@PathVariable Long id, @RequestBody WorkoutSession session) {
        return workoutSessionService.updateWorkout(id, session);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        workoutSessionService.deleteWorkout(id);
    }
}
