package pl.wsb.wsbspringgr2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import pl.wsb.wsbspringgr2.entity.TaskEntity;
import pl.wsb.wsbspringgr2.model.NewTodoDto;
import pl.wsb.wsbspringgr2.service.TodoService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @PostMapping("/api/v1/todos")
    public ResponseEntity<TaskEntity> addTodo(@Valid @RequestBody NewTodoDto newTask){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.addTask(TaskEntity.builder()
                .deadline(newTask.getDeadline())
                .title(newTask.getTitle())
                .email(newTask.getEmail())
                .build()
        ));
    }

    @PutMapping("/api/v1/todos/{id}")
    public void updateTodo(@RequestBody NewTodoDto updatedTask, @PathVariable long id){
        Optional<TaskEntity> entity = service.findAll().stream().filter(task -> task.getId() == id).findFirst();
        if (!entity.isPresent()){
            throw new IllegalArgumentException("Podane id nieistniejącego zadania!");
        }
        //To należy zrobić w serwisie - w zdefiniowanej metodzie np. updateTodo(..)
        TaskEntity task = entity.get();
        task.setDeadline(updatedTask.getDeadline());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ResponseEntity<String> handleInvalidTaskId(IllegalArgumentException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
