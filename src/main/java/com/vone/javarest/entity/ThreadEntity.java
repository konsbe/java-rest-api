package com.vone.javarest.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "mt-thread")
public class ThreadEntity {

    @Id
    @GeneratedValue
    @Column(name = "thread_id")
    private final UUID id;
    
    @Column(name = "thread_header")
    private final String threadHeader;
    
    @Column(name = "thread_body")
    private final String threadBody;
    
    @Column(name = "thread_likes")
    private final int likes;
    
    @Column(name = "thread_date_created")
    private final Timestamp dateCreated;
    
    @OneToMany(targetEntity = CommentEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "c_thread_id", referencedColumnName = "thread_id")
    private ArrayList<CommentEntity> comments;
    
    
    public ThreadEntity(String thread_header, String thread_body) {
        this.id = UUID.randomUUID();
        this.threadHeader = thread_header;
        this.threadBody = thread_body;
        this.likes = 0;
        this.dateCreated = new Timestamp(System.currentTimeMillis());
    }

    public UUID getId() {
        return id;
    }
    public String getThreadHeader() {
        return threadHeader;
    }
    public String getThreadBody() {
        return threadBody;
    }
    public int getLikes() {
        return likes;
    }
    public Timestamp getDateNow() {
        return dateCreated;
    }
    
    
}
