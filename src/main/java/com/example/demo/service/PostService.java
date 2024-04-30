package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;


    public String createPost(Post post) {
        if (!userRepository.existsById(post.getUserID())){
            return "User does not exist";
        }
        postRepository.save(post);
        return "Post created successfully";
    }

    public Optional<Post> getPost(Long postId) {
        return postRepository.findById(postId);
    }

    public String updatePost(Long postId, String body) {
        Optional<Post> post = postRepository.findById(postId);
        if(post.isEmpty()) {
            return "Post does not exist";
        }
        post.get().setBody(body);
        postRepository.save(post.get());
        return "Post edited successfully";
    }

    public String deletePost(Long postId) {
        if(!postRepository.existsById(postId)) {
            return "Post does not exist";
        }
        postRepository.deleteById(postId);
        return "Post deleted";
    }

    public List<Post> getAllPosts() {
        return postRepository.findAllByOrderByDateDesc();
    }
}
