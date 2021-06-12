package pl.wsb.wsbspringgr2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.wsb.wsbspringgr2.entity.TaskEntity;
import pl.wsb.wsbspringgr2.service.TodoService;

import java.util.List;
import java.util.Optional;

@RestController
public class TodoRestController {
    private final TodoService service;

    @Autowired
    public TodoRestController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/api/v1/todos")
    public List<TaskEntity> todos(){
        return service.findAll();
    }

    @GetMapping("/api/v1/todos/{taskId}")
    public ResponseEntity<TaskEntity> todoById(@PathVariable long taskId){
        return  ResponseEntity.of(service.findAll().stream().filter(task -> task.getId() == taskId).findFirst());
    }
}
