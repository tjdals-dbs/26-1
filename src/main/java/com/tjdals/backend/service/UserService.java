package com.tjdals.backend.service;

import com.tjdals.backend.domain.User;
import com.tjdals.backend.repository.UserRepository;
import com.tjdals.backend.controller.dto.UserCreateRequest;
import com.tjdals.backend.controller.dto.UserUpdateRequest;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User create(UserCreateRequest req){
        User user = new User();
        user.setName(req.name());
        user.setEmail(req.email());
        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User findUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public void deleteUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        userRepository.delete(user);
    }

    public User updateUser(Long id, UserUpdateRequest req){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        user.setName(req.name());
        user.setEmail(req.email());
        return userRepository.save(user);
    }
}
