package com.tjdals.backend.service;

import com.tjdals.backend.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();

    public void addUser(User user){
        users.add(user);
    }

    public List<User> getUsers(){
        return users;
    }

    public User findUserById(Long id){
        for(User user : users){
            if(user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }
}
