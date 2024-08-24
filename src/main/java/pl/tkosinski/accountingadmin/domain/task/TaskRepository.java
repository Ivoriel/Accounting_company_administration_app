package pl.tkosinski.accountingadmin.domain.task;

import pl.tkosinski.accountingadmin.common.BaseRepository;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.task.dto.TaskAssignmentDto;

import java.util.Optional;

interface TaskRepository extends BaseRepository<TaskDao> {

    TaskDao save(TaskDao taskDao);

    Optional<TaskDao> get(Id id);

    void delete(Id id);

    int size();

    TaskDao generate();

    TaskDao generateAndSave();

    void assignTask(TaskAssignmentDto dto);
}
