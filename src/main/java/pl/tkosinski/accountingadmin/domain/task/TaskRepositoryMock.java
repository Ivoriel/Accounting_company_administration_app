package pl.tkosinski.accountingadmin.domain.task;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The purpose of this class is to operate as a mock db during development.
 */

@Component
@AllArgsConstructor
public class TaskRepositoryMock implements TaskRepository {

    HashMap<Long, TaskDao> taskDb;

    @PostConstruct
    public void init() {
        populateTaskDb();
    }

    @Override
    public TaskDao save(TaskDao taskDao) {
        taskDb.put(taskDao.getId(), taskDao);
        return taskDb.get(taskDao.getId());
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

    private void populateTaskDb() {
        for (long i = 1; i < 10; i++) {
            generateAndSave();
        }
    }

    private int generateRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max +1);
    }
}
