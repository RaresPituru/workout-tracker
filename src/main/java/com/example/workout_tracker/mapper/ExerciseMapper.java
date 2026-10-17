package com.example.workout_tracker.mapper;

import com.example.workout_tracker.dto.CreateExerciseRequest;
import com.example.workout_tracker.dto.CreateUserRequest;
import com.example.workout_tracker.dto.ExerciseResponse;
import com.example.workout_tracker.entities.Exercise;
import com.example.workout_tracker.entities.User;

public class ExerciseMapper {
    public static ExerciseResponse toResponse(Exercise exercise){
        return new ExerciseResponse(exercise.getId(),exercise.getName(),exercise.getMuscleGroup());
    }

    public static Exercise toEntity(CreateExerciseRequest request) {
       Exercise exercise = new Exercise();
       exercise.setName(request.getName());
       exercise.setMuscleGroup(request.getMuscleGroup());
       return exercise;
    }
}
