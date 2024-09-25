package com.taskmanager.repository;

import com.taskmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.sterotype.Repository;

@Repository
public interface TaskRepositry extends JpaRepository<Task, Long> {

}

