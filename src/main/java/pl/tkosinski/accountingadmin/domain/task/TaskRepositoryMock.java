package pl.tkosinski.accountingadmin.domain.task;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.common.model.Comment;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.user.UserFacade;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The purpose of this class is to operate as a mock db during development.
 */

@Component
@AllArgsConstructor
class TaskRepositoryMock implements TaskRepository {

    HashMap<Id, TaskDao> taskDb;
    UserFacade userFacade;

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
    public Optional<TaskDao> get(Id id) {
        return Optional.of(taskDb.get(id));
    }

    @Override
    public void delete(Id id) {
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
                .id(Id.ofValue(taskDb.size()))
                .performerId(userFacade.getRequestedOrGenerateAndSave(Id.ofValue(size())).getId())
                .start(LocalDateTime.now().minusMinutes(start))
                .end(LocalDateTime.now().minusMinutes(start+60L))
                .comment(Comment.ofValue("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed at."))
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
