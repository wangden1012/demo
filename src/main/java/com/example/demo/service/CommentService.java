package com.example.demo.service;

import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    public String createComment(Comment comment) {
        if(!postRepository.existsById(comment.getPost().getId())){
            return "Post does not exists";
        }
        commentRepository.save(comment);
        return "Comment created successfully";
    }

    public Optional<Comment> getComment(Long commentId) {
        return commentRepository.findById(commentId);
    }

    public String updateComment(Long commentId, String body) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if(comment.isEmpty()){
            return "Comment does not exist";
        }
        comment.get().setBody(body);
        commentRepository.save(comment.get());
        return "Comment edited successfully";
    }

    public String deleteComment(Long commentId) {
        if(!commentRepository.existsById(commentId)){
            return "Comment does not exist";
        }
        commentRepository.deleteById(commentId);
        return "Comment deleted";
    }
}
