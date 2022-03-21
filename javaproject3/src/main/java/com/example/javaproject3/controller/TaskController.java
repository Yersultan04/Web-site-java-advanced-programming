package com.example.javaproject3.controller;



import com.example.javaproject3.model.Task;
import com.example.javaproject3.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;



    @GetMapping("/addTask")
    public String showNewForm(Model model){
        Task task = new Task();
        model.addAttribute("task",task);
        return "task/new_task";
    }

    @PostMapping("/saveTask")
    public String saveTask(@ModelAttribute("task") Task task){
        taskService.addTask(task);
        return "redirect:/user/home";
    }


    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable(value = "id") int id, Model model){
        Task task = taskService.getTaskById(id);
        model.addAttribute("task",task);
        return "task/update_task";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable(value = "id") int id){
        taskService.deleteTaskById(id);
        return "redirect:/user/home";

    }



}
