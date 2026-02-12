package com.tjdals.backend.controller;

import com.tjdals.backend.domain.User;
import com.tjdals.backend.service.UserService;
import com.tjdals.backend.controller.dto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponse create(@Valid @RequestBody UserCreateRequest req){
        return UserResponse.from(userService.create(req));
    }

    @GetMapping
    public List<UserResponse> getUsers(){
        return userService.getUsers().stream()
                .map(UserResponse::from).toList();
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@Valid @PathVariable Long id){
        return UserResponse.from(userService.findUserById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateRequest req){
        return UserResponse.from(userService.updateUser(id, req));
    }
}
