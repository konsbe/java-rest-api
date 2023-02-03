package com.vone.javarest.entity;

import java.sql.Timestamp;
import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "mt-thread")
public class ThreadEntity {

    @Id
    @GeneratedValue
    @Column(name = "thread_id")
    private final Long thread_id;
    
    @Column(name = "thread_header")
    private final String thread_header;
    
    @Column(name = "thread_body")
    private final String thread_body;
    
    @Column(name = "thread_likes")
    private final int thread_likes;
    
    @Column(name = "thread_date_created")
    private final Timestamp thread_date_created;

    // private ArrayList<CommentEntity> comments;
    
    // @OneToMany(targetEntity = CommentEntity.class, cascade = CascadeType.ALL)
    // @JoinColumn(name = "c_thread_id", referencedColumnName = "thread_id")
    // private ArrayList<CommentEntity> comments;
    
    
    public ThreadEntity(Long thread_id, String thread_header, String thread_body) {
        this.thread_id = new Random().nextLong();
        this.thread_header = thread_header;
        this.thread_body = thread_body;
        this.thread_likes = 0;
        this.thread_date_created = new Timestamp(System.currentTimeMillis());
        // this.comments = new ArrayList<CommentEntity>();
    }


    public Long getThread_id() {
        return thread_id;
    }


    public String getThread_header() {
        return thread_header;
    }


    public String getThread_body() {
        return thread_body;
    }


    public int getThread_likes() {
        return thread_likes;
    }


    public Timestamp getThread_date_created() {
        return thread_date_created;
    }


    // public ArrayList<CommentEntity> getComments() {
    //     return comments;
    // }


    // public void setComments(ArrayList<CommentEntity> comments) {
    //     this.comments = comments;
    // }


    
    
}
