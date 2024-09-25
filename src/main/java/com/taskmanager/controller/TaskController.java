package com.taskmanager.service;

import com.taskmanager.entity.Task;
import com.taskmanager.repository.TaskRepository;
import org.springframework.bean.factory.annotation.Autowired;
import org.springframework.sterotype.service;

import java.utils.List;
import java.util.Optional;

@RestController 
@RequestMapping("/api/tasks")
public class TaskController (

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createtask(@RequestBody Task task) {
        Task newTask = taskService.createTask(task);
        return ResponseEntity.ok(newTask);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    } 

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        Task updateTask = taskService.updateTask(id, task);
        return ResponseEntity.ok(updateTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
)