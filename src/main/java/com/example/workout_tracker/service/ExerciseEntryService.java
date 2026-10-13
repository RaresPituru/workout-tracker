package com.example.workout_tracker.service;

import com.example.workout_tracker.entities.Exercise;
import com.example.workout_tracker.entities.ExerciseEntry;
import com.example.workout_tracker.entities.WorkoutSession;
import com.example.workout_tracker.exceptions.ResourceNotFoundException;
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

    public ExerciseEntry createExerciseEntry(Long workoutSessionId,Long exerciseId,ExerciseEntry exerciseEntry){
        WorkoutSession workoutSession = workoutSessionRepository.findById(workoutSessionId)
                .orElseThrow(() -> new RuntimeException("Workout not found"));
        Exercise exercise = exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new RuntimeException("Exercise not found"));

        exerciseEntry.setExercise(exercise);
        exerciseEntry.setWorkoutSession(workoutSession);

        return exerciseEntryRepository.save(exerciseEntry);
    }

    public ExerciseEntry getExerciseEntryById(Long id){
        return exerciseEntryRepository.findById(id).orElseThrow(() -> new RuntimeException("ExerciseEntry not found"));
    }

    public void deleteExerciseEntry(Long id){
        if(!exerciseEntryRepository.existsById(id)){
            throw new ResourceNotFoundException("entry not found");
        }
        exerciseEntryRepository.deleteById(id);
    }

    public ExerciseEntry updateExerciseEntry(Long id, ExerciseEntry newData) {
       ExerciseEntry exerciseEntry = exerciseEntryRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("entry not found"));

       exerciseEntry.setWeight(newData.getWeight());
       exerciseEntry.setReps(newData.getReps());
       exerciseEntry.setSets(newData.getSets());

       return exerciseEntryRepository.save(exerciseEntry);

    }

}
