package com.example.javaproject3.services;


import com.example.javaproject3.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    void addTask(Task task);
    Task getTaskById(int id);
    void deleteTaskById(int id);
}
