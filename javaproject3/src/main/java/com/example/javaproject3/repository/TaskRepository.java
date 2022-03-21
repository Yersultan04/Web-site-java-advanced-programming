package com.example.javaproject3.repository;


import com.example.javaproject3.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
