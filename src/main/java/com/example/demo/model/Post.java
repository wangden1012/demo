package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String body;

    @Temporal(TemporalType.TIMESTAMP)
    //@Column(nullable = false)
    private Date date = new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Long userID;



    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    //Getters

    public Post() {};

    public Post(String body, Long userID) {
        this.body = body;
        this.userID = userID;
    }

    public Long getUserID() {
        return userID;
    }

    public Long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public Date getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }


    public List<Comment> getComments() {
        return comments;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}


