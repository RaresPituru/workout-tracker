package com.example.workout_tracker.service;

import com.example.workout_tracker.dto.CreateWorkoutSessionRequest;
import com.example.workout_tracker.dto.WorkoutSessionResponse;
import com.example.workout_tracker.entities.User;
import com.example.workout_tracker.entities.WorkoutSession;
import com.example.workout_tracker.exceptions.ResourceNotFoundException;
import com.example.workout_tracker.mapper.UserMapper;
import com.example.workout_tracker.mapper.WorkoutSessionMapper;
import com.example.workout_tracker.repository.UserRepository;
import com.example.workout_tracker.repository.WorkoutSessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkoutSessionService {
    private final WorkoutSessionRepository workoutSessionRepository;
    private final UserRepository userRepository;

    public WorkoutSessionService(WorkoutSessionRepository workoutSessionRepository, UserRepository userRepository) {
        this.workoutSessionRepository = workoutSessionRepository;
        this.userRepository = userRepository;
    }


    public WorkoutSessionResponse createWorkout(Long userId,CreateWorkoutSessionRequest request){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        WorkoutSession session = WorkoutSessionMapper.toEntity(request);
        session.setUser(user);

        WorkoutSession saved = workoutSessionRepository.save(session);
        return WorkoutSessionMapper.toResponse(saved);

    }
    public List<WorkoutSessionResponse> getAllWorkouts(){

        List<WorkoutSession> workoutSessions = workoutSessionRepository.findAll();
        return workoutSessions.stream().map(WorkoutSessionMapper::toResponse)
                .collect(Collectors.toList());
    }
    public void deleteWorkout(Long id){
        if(!workoutSessionRepository.existsById(id)){
            throw new ResourceNotFoundException("workout not found");
        }
        workoutSessionRepository.deleteById(id);
    }
    public WorkoutSessionResponse getWorkoutById(Long id){
        WorkoutSession workoutSession = workoutSessionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Workout not found"));

        return WorkoutSessionMapper.toResponse(workoutSession);
    }
    public WorkoutSessionResponse updateWorkout(Long id, CreateWorkoutSessionRequest newData) {
        WorkoutSession workoutSession = workoutSessionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Workout not found"));

        workoutSession.setDate(newData.getDate());
        WorkoutSession saved = workoutSessionRepository.save(workoutSession);

        return WorkoutSessionMapper.toResponse(saved);
    }
}
