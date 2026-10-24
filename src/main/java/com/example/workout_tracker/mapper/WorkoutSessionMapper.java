package com.example.workout_tracker.mapper;

import com.example.workout_tracker.dto.CreateWorkoutSessionRequest;
import com.example.workout_tracker.dto.WorkoutSessionResponse;
import com.example.workout_tracker.entities.WorkoutSession;


public class WorkoutSessionMapper {

    public static WorkoutSessionResponse toResponse(WorkoutSession workoutSession){
        return new WorkoutSessionResponse(workoutSession.getId(),workoutSession.getDate(),workoutSession.getUser().getId());
    }

    public static WorkoutSession toEntity(CreateWorkoutSessionRequest workoutSessionRequest){
        WorkoutSession workoutSession = new WorkoutSession();
        workoutSession.setDate(workoutSessionRequest.getDate());
        return workoutSession;
    }
}
