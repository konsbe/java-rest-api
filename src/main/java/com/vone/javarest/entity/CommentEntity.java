package com.vone.javarest.entity;

import java.sql.Timestamp;
import java.util.Random;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mt-comments")
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
    
    @ManyToOne(targetEntity = ThreadEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "c_thread_id", referencedColumnName = "thread_id")
    private Long cThreadId;
    
    public CommentEntity(String comment, String userName) {
        this.id = new Random().nextLong();
        this.comment = comment;
        this.userName = userName;
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
