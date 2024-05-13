package com.example.recipemlker.service.impl;

import com.example.recipemlker.model.Comment;
import com.example.recipemlker.repository.CommentRepository;
import com.example.recipemlker.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }
}
