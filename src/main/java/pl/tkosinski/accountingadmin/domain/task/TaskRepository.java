package pl.tkosinski.accountingadmin.domain.task;

import pl.tkosinski.accountingadmin.common.BaseRepository;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.task.dto.TaskAssignmentDto;

import java.time.LocalDateTime;
import java.util.Optional;

interface TaskRepository extends BaseRepository<TaskEntity> {

    TaskEntity save(TaskEntity taskEntity);

    Optional<TaskEntity> get(Id id);

    void delete(Id id);

    int size();

    TaskEntity generate();

    TaskEntity generateAndSave();

    void assignTask(TaskAssignmentDto dto);

    LocalDateTime beginTask(Id taskId);

    LocalDateTime finishTask(Id taskId);
}
