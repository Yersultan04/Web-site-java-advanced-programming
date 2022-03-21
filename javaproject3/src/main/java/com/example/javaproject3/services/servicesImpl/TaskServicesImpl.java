package com.example.javaproject3.services.servicesImpl;


import com.example.javaproject3.model.Task;
import com.example.javaproject3.repository.TaskRepository;
import com.example.javaproject3.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServicesImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void addTask(Task task) {
        this.taskRepository.save(task);
    }

    @Override
    public Task getTaskById(int id) {
        Optional<Task> optional = taskRepository.findById(id);
        Task task = null;
        if (optional.isPresent()) {
            task = optional.get();
        }
        else {
            throw new RuntimeException("Task not found for id - " + id);
        }
        return task;
    }

    @Override
    public void deleteTaskById(int id) {
        this.taskRepository.deleteById(id);
    }
}

