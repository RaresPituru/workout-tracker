package com.example.workout_tracker.service;

import com.example.workout_tracker.dto.CreateExerciseEntryRequest;
import com.example.workout_tracker.dto.ExerciseEntryResponse;
import com.example.workout_tracker.entities.Exercise;
import com.example.workout_tracker.entities.ExerciseEntry;
import com.example.workout_tracker.entities.WorkoutSession;
import com.example.workout_tracker.exceptions.ResourceNotFoundException;
import com.example.workout_tracker.mapper.ExerciseEntryMapper;
import com.example.workout_tracker.repository.ExerciseEntryRepository;
import com.example.workout_tracker.repository.ExerciseRepository;
import com.example.workout_tracker.repository.WorkoutSessionRepository;
import org.springframework.stereotype.Service;

@Service
public class ExerciseEntryService {
    private final ExerciseRepository exerciseRepository;
    private final WorkoutSessionRepository workoutSessionRepository;
    private final ExerciseEntryRepository exerciseEntryRepository;

    public ExerciseEntryService(ExerciseRepository exerciseRepository, WorkoutSessionRepository workoutSessionRepository, ExerciseEntryRepository exerciseEntryRepository){
        this.exerciseRepository = exerciseRepository;
        this.workoutSessionRepository = workoutSessionRepository;
        this.exerciseEntryRepository = exerciseEntryRepository;
    }

    public ExerciseEntryResponse createExerciseEntry(Long workoutSessionId, Long exerciseId, CreateExerciseEntryRequest request){
        WorkoutSession workoutSession = workoutSessionRepository.findById(workoutSessionId)
                .orElseThrow(() -> new ResourceNotFoundException("Workout not found"));
        Exercise exercise = exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new ResourceNotFoundException("Exercise not found"));

        ExerciseEntry entry;
        entry = ExerciseEntryMapper.toEntity(request);
        entry.setExercise(exercise);
        entry.setWorkoutSession(workoutSession);

        ExerciseEntry saved = exerciseEntryRepository.save(entry);
        return ExerciseEntryMapper.toResponse(saved);
    }

    public ExerciseEntryResponse getExerciseEntryById(Long id){
        ExerciseEntry exerciseEntry = exerciseEntryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ExerciseEntry not found"));

        return ExerciseEntryMapper.toResponse(exerciseEntry);
    }

    public void deleteExerciseEntry(Long id){
        if(!exerciseEntryRepository.existsById(id)){
            throw new ResourceNotFoundException("entry not found");
        }
        exerciseEntryRepository.deleteById(id);
    }

    public ExerciseEntryResponse updateExerciseEntry(Long id, CreateExerciseEntryRequest request) {
        ExerciseEntry exerciseEntry = exerciseEntryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entry not found"));

        exerciseEntry.setWeight(request.getWeight());
        exerciseEntry.setReps(request.getReps());
        exerciseEntry.setSets(request.getSets());

        ExerciseEntry saved = exerciseEntryRepository.save(exerciseEntry);
        return ExerciseEntryMapper.toResponse(saved);
    }

}
