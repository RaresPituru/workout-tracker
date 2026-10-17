package com.example.workout_tracker.mapper;

import com.example.workout_tracker.dto.CreateUserRequest;
import com.example.workout_tracker.dto.UserResponse;
import com.example.workout_tracker.entities.User;

public class UserMapper {
    public static UserResponse toResponse(User user) {
        return new UserResponse(user.getId(), user.getUsername(), user.getEmail());
    }

    public static User toEntity(CreateUserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return user;
    }
}
