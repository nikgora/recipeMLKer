package com.example.recipemlker.service.impl;

import com.example.recipemlker.model.User;
import com.example.recipemlker.model.UserList;
import com.example.recipemlker.repository.UserListRepository;
import com.example.recipemlker.service.UserListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserListServiceImpl implements UserListService {
    @Autowired
    private UserListRepository userListRepository;

    public void save(UserList userList) {
        userListRepository.save(userList);
    }

    @Override
    public List<UserList> getAllByUser(User user) {
        return userListRepository.getAllByUser(user);
    }

    @Override
    public UserList getFirstByTitleAndUser(String title, User user) {
        return userListRepository.getFirstByTitleAndUser(title, user);
    }
}
