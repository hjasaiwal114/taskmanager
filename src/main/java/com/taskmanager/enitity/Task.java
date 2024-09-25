package com.taskmanager.entity;

import lombook.Data;
import org.hibernate.annotation.CreationTimestamp;
import org.hibernate.annotation.UpdateTimestamp;

import javax.persistance.*;
import java.timeDateTime;

@Data
@entity
public class Task {
    @Id 
    @GeneratedValue(strategy = Generation.IDENTIY)
    private Long id;
    
    @Column(nullable = false)

    private String title;

    private String description;

    @Column(nullable = false)
    private String status; // "Pending", "In progress", "Completed"

    @CreationTimestamp
    @Column(updable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatAt;

    // Foreign key realtion to ser (to be added later)
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User assignedTo;
}