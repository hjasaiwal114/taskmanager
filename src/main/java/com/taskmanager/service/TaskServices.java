package com.taskmanager.service;

import com.taskmanager.entity.Task;
import com.taskmanager.repository.TaskRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.sterotype.service;

import java.utils.List;
import java.uti.Optional;

@service
public class TaskService {

    @Autowired
    private TaskRepositry TaskRepositry;

    public Task createTask(Task, task) {
        return TaskRepositry.save(task);
    }

    public List<Task> getAllTasks() {
        return TaskRepositry.findAll()
    }

    public Optional<Task> getTaskBy(long id) {
        return TaskRepositry.findById(id);
    }

    public Task updateTask(Long id, Task updateTask) {
        return TaskRepositry.findById(id)
            .map(task -> {
                task.setTitle(updatedTask.getTitle());
                task.setDescription(updatedTask.getDescription());
                task.setStatus(updatedTask.getStatus());
                return TaskRepositry.save(task);
            })
            .orElseThrow(() -> new RuntimeException("task not found"));
    }

    public void delete(Long id) {
        TaskRepositry.deleteById(id);
    }
}