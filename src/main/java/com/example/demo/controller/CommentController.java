package com.example.demo.controller;

import com.example.demo.model.Comment;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Optional;


@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<?> createComment(@RequestBody Comment comment) {
        String result = commentService.createComment(comment);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<?> getComment(@PathVariable Long commentId) {
        Optional<Comment> comment = commentService.getComment(commentId);
        if (comment.isPresent()) {
            return ResponseEntity.ok(comment);
        }
        else {
            return ResponseEntity.status(404).body("Comment does not exist");
        }
    }

    @PatchMapping("/{commentId}")
    public ResponseEntity<?> updateComment(@PathVariable Long commentId, @RequestBody String body) {
        String result = commentService.updateComment(commentId, body);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Long commentId) {
        String result = commentService.deleteComment(commentId);
        return ResponseEntity.ok(result);
    }
}
