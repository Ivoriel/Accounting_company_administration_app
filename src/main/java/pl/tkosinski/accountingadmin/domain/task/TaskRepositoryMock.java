package pl.tkosinski.accountingadmin.domain.task;

import java.util.HashMap;
import java.util.Optional;

public class TaskRepositoryMock implements TaskRepository {

    HashMap<Long, TaskDao> taskDb;

    @Override
    public TaskDao save(TaskDao taskDao) {
        return taskDb.put(taskDao.getId(), taskDao);
    }

    @Override
    public Optional<TaskDao> get(long id) {
        return Optional.of(taskDb.get(id));
    }

    @Override
    public void delete(long id) {
        taskDb.remove(id);
    }

    @Override
    public int size() {
        return taskDb.size();
    }

    @Override
    public TaskDao generate() {
        return null;
    }

    @Override
    public TaskDao generateAndSave() {
        return null;
    }
}
