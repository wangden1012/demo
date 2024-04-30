package com.example.demo.repository;
import com.example.demo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserIdOrderByDateDesc(Long userId); //fetch posts by a specific user, sorted by descending date
    List<Post> findAllByOrderByDateDesc(); //fetch all posts for the feed, sorted by date descending
}
