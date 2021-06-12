package pl.wsb.wsbspringgr2.service;

import org.springframework.stereotype.Service;
import pl.wsb.wsbspringgr2.entity.TaskEntity;
import pl.wsb.wsbspringgr2.repository.TaskRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TodoServiceJpa implements TodoService{
    private final TaskRepository taskRepository;

    public TodoServiceJpa(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskEntity addTask(TaskEntity task) {
        return taskRepository.save(task);
    }

    @Override
    public List<TaskEntity> findAll() {
        return taskRepository.findAll();
    }

    @Transactional
    @Override
    public void setAsDone(long taskId) {
        taskRepository.findById(taskId)
                .ifPresent(task ->{
                    task.setDone(true);
                });
    }
}
