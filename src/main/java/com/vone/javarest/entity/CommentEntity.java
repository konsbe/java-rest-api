package com.vone.javarest.entity;

import java.sql.Timestamp;
import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "mt-comments")
@Data
public class CommentEntity {
    
    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long id;
    @Column(name = "comment_body")
    private String comment;
    @Column(name = "comment_user_name")
    private String userName;
    @Column(name = "comment_date_created")
    private Timestamp dateCreated;
    
    @Column(name = "c_thread_id")
    private Long cThreadId;
    
    public CommentEntity(){};
    public CommentEntity(String comment, String userName, Long threadId) {
        this.id = new Random().nextLong();
        this.comment = comment;
        this.userName = userName;
        this.cThreadId = threadId;
        this.dateCreated = new Timestamp(System.currentTimeMillis());
    }
    public Long getId() {
        return id;
    }
    public String getComment() {
        return comment;
    }
    public String getUserName() {
        return userName;
    }
    public Timestamp getDateCreated() {
        return dateCreated;
    }

    

}
