package com.examine.service;

import com.examine.model.Comment;
import com.examine.repository.CommentRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentService {
    @Resource
    private CommentRepository commentRepository;

    public int insertComment(Comment comment){
        return commentRepository.insertComment(comment);
    }

    public List<Comment> findAll(){
        return commentRepository.getAll();
    }
}
