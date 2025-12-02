package pl.tkosinski.accountingadmin.domain.task;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.common.model.Text;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.common.model.TimeRange;
import pl.tkosinski.accountingadmin.domain.company.CompanyFacade;
import pl.tkosinski.accountingadmin.domain.task.dto.TaskAssignmentDto;
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

    HashMap<Id, TaskEntity> taskDb;
    UserFacade userFacade;
    CompanyFacade companyFacade;

    @PostConstruct
    public void init() {
        populateTaskDb();
    }

    @Override
    public TaskEntity save(TaskEntity taskEntity) {
        taskDb.put(taskEntity.getId(), taskEntity);
        return taskDb.get(taskEntity.getId());
    }

    @Override
    public Optional<TaskEntity> get(Id id) {
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
    public TaskEntity generate() {
        var start = generateRandomInt(60, 240);

        return TaskEntity.builder()
                .id(Id.generate())
                .performerId(userFacade.getRequestedOrGenerateAndSave(Id.generate()).id())
                .clientCompanyId(companyFacade.getRequestedOrGenerateAndSave(Id.generate()).id())
                .period(TimeRange.ofValue(LocalDateTime.now().minusMinutes(start)))
                .title(Text.ofValue("Lorem ipsum dolor sit amet"))
                .comment(Text.ofValue("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed at."))
                .build();
    }

    @Override
    public TaskEntity generateAndSave() {
        return save(generate());
    }

    @Override
    public void assignTask(TaskAssignmentDto dto) {
        taskDb.get(dto.taskId()).assignTask(dto.performerId());
    }

    @Override
    public void beginTask(Id taskId) {
        taskDb.get(taskId).beginTask();
    }

    @Override
    public void finishTask(Id taskId) {
        taskDb.get(taskId).finishTask();
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
