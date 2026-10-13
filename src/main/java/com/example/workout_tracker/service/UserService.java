package com.example.workout_tracker.service;

import com.example.workout_tracker.entities.User;
import com.example.workout_tracker.exceptions.ResourceNotFoundException;
import com.example.workout_tracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
    public User createUser(User user){
        return userRepository.save(user);
    }
    public void deleteUser(Long id){
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found");
        }
        userRepository.deleteById(id);
    }
}
