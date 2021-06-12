package pl.wsb.wsbspringgr2.service;

import pl.wsb.wsbspringgr2.entity.TaskEntity;
import pl.wsb.wsbspringgr2.model.TaskToDo;

import java.util.List;

public interface TodoService {
    TaskEntity addTask(TaskEntity task);

    List<TaskEntity> findAll();

    void setAsDone(long taskId);
}