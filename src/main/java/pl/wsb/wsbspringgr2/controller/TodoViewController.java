package pl.wsb.wsbspringgr2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wsb.wsbspringgr2.entity.TaskEntity;
import pl.wsb.wsbspringgr2.model.DoneTaskDto;
import pl.wsb.wsbspringgr2.model.NewTodoDto;
import pl.wsb.wsbspringgr2.service.TodoService;

import java.time.LocalDate;

@Controller
public class TodoViewController {
    private final TodoService service;

    public TodoViewController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/todo/list")
    public String todos(Model model) {
        model.addAttribute("tasks", service.findAll());
        return "list-task";
    }

    @GetMapping("/todo/add")
    public String addTodoForm() {
        return "add-task-form";
    }

    @PostMapping("/todo/add")
    public String addTodo(NewTodoDto task) {
        service.addTask(
                TaskEntity.builder()
                        .email(task.getEmail())
                        .title(task.getTitle())
                        .deadline(task.getDeadline())
                        .build()
        );
        //przekierowanie do ścieżki /todo/list
        return "redirect:/todo/list";
    }

    @PostMapping("todo/done")
    public String setTaskAsDone(DoneTaskDto taskDone){
        service.setAsDone(taskDone.getDone());
        return "redirect:/todo/list";
    }

}
