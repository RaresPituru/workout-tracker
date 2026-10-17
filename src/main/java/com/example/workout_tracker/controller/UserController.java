package com.example.workout_tracker.controller;

import com.example.workout_tracker.dto.CreateUserRequest;
import com.example.workout_tracker.dto.UpdateUserRequest;
import com.example.workout_tracker.dto.UserResponse;
import com.example.workout_tracker.entities.User;
import com.example.workout_tracker.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponse> getAll(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @PostMapping
    public UserResponse create(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    @PutMapping("/{id}")
    public UserResponse update(@PathVariable Long id, @RequestBody UpdateUserRequest request) {
        return userService.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
