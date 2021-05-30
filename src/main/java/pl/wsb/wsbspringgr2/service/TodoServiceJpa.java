package pl.wsb.wsbspringgr2.service;

import org.springframework.stereotype.Service;
import pl.wsb.wsbspringgr2.entity.TaskEntity;
import pl.wsb.wsbspringgr2.repository.TaskRepository;
import java.util.List;

@Service
public class TodoServiceJpa implements TodoService{
    private final TaskRepository taskRepository;

    public TodoServiceJpa(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void addTask(TaskEntity task) {
        taskRepository.save(task);
    }

    @Override
    public List<TaskEntity> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public void setAsDone(long taskId) {

    }
}
