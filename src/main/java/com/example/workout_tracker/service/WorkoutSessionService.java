package com.example.workout_tracker.service;

import com.example.workout_tracker.entities.User;
import com.example.workout_tracker.entities.WorkoutSession;
import com.example.workout_tracker.exceptions.ResourceNotFoundException;
import com.example.workout_tracker.repository.UserRepository;
import com.example.workout_tracker.repository.WorkoutSessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutSessionService {
    private final WorkoutSessionRepository workoutSessionRepository;
    private final UserRepository userRepository;

    public WorkoutSessionService(WorkoutSessionRepository workoutSessionRepository, UserRepository userRepository) {
        this.workoutSessionRepository = workoutSessionRepository;
        this.userRepository = userRepository;
    }


    public WorkoutSession createWorkout(Long userId,WorkoutSession session){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        session.setUser(user);
        return workoutSessionRepository.save(session);

    }
    public List<WorkoutSession> getAllWorkouts(){
        return workoutSessionRepository.findAll();
    }
    public void deleteWorkout(Long id){
        if(!workoutSessionRepository.existsById(id)){
            throw new ResourceNotFoundException("workout not found");
        }
        workoutSessionRepository.deleteById(id);
    }
    public WorkoutSession getWorkoutById(Long id){
        return workoutSessionRepository.findById(id).orElseThrow(() -> new RuntimeException("Workout not found"));
    }
    public WorkoutSession updateWorkout(Long id, WorkoutSession newData) {
        WorkoutSession workoutSession = workoutSessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workout not found"));

        workoutSession.setDate(newData.getDate());
        return workoutSessionRepository.save(workoutSession);
    }
}
