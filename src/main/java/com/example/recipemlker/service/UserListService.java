package com.example.recipemlker.service;

import com.example.recipemlker.model.User;
import com.example.recipemlker.model.UserList;

import java.util.List;

public interface UserListService {
    public void save(UserList userList);

    List<UserList> getAllByUser(User user);

    UserList getFirstByTitleAndUser(String title, User user);
}
