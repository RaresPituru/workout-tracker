package com.example.workout_tracker.service;

import com.example.workout_tracker.dto.CreateUserRequest;
import com.example.workout_tracker.dto.UpdateUserRequest;
import com.example.workout_tracker.dto.UserResponse;
import com.example.workout_tracker.entities.User;
import com.example.workout_tracker.exceptions.ResourceNotFoundException;
import com.example.workout_tracker.mapper.UserMapper;
import com.example.workout_tracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserResponse> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::toResponse).collect(Collectors.toList());
    }

    public UserResponse getUserById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return UserMapper.toResponse(user);
    }
    public UserResponse createUser(CreateUserRequest request) {
        User user = UserMapper.toEntity(request);
        User saved = userRepository.save(user);
        return UserMapper.toResponse(saved);
    }

    public UserResponse updateUser(Long id, UpdateUserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());

        User saved = userRepository.save(user);
        return UserMapper.toResponse(saved);
    }

    public void deleteUser(Long id){
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found");
        }
        userRepository.deleteById(id);
    }
}
