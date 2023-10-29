package pl.tkosinski.accountingadmin.domain.task;

import java.util.HashMap;
import java.util.Optional;

public class TaskRepositoryMock implements TaskRepository {

    HashMap<Long, TaskDao> taskDb;

    @Override
    public TaskDao save(TaskDao clientDao) {
        return null;
    }

    @Override
    public Optional<TaskDao> get(long id) {
        return Optional.empty();
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public int size() {
        return 0;
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
