package pl.tkosinski.accountingadmin.domain.task;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

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
        var start = generateRandomInt(60, 240);

        return TaskDao.builder()
                .id(taskDb.size())
                .start(LocalDateTime.now().minusMinutes(start))
                .end(LocalDateTime.now().minusMinutes(start+60))
                .build();
    }

    @Override
    public TaskDao generateAndSave() {
        return save(generate());
    }

    private int generateRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max +1);
    }
}
