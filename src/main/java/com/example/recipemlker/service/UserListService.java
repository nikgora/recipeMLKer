package com.example.recipemlker.service;

import com.example.recipemlker.model.User;
import com.example.recipemlker.model.UserList;

public interface UserListService {
    public void save(UserList userList);

    UserList getFirstByTitleAndUser(String title, User user);
}
