package com.example.workout_tracker.mapper;

import com.example.workout_tracker.dto.CreateExerciseEntryRequest;
import com.example.workout_tracker.dto.ExerciseEntryResponse;

import com.example.workout_tracker.entities.ExerciseEntry;

public class ExerciseEntryMapper {
    public static ExerciseEntryResponse toResponse(ExerciseEntry exerciseEntry){
        return new ExerciseEntryResponse(exerciseEntry.getId(),exerciseEntry.getSets(),exerciseEntry.getReps()
        ,exerciseEntry.getWeight(),exerciseEntry.getWorkoutSession().getId(),exerciseEntry.getExercise().getId()
        ,exerciseEntry.getExercise().getName());
    }

    public static ExerciseEntry toEntity(CreateExerciseEntryRequest request){
        ExerciseEntry exerciseEntry = new ExerciseEntry();
        exerciseEntry.setSets(request.getSets());
        exerciseEntry.setReps(request.getReps());
        exerciseEntry.setWeight(request.getWeight());

        return exerciseEntry;
    }
}
