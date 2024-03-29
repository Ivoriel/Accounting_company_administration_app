package pl.tkosinski.accountingadmin.domain.task;

import pl.tkosinski.accountingadmin.common.BaseRepository;
import pl.tkosinski.accountingadmin.common.model.Id;

import java.util.Optional;

public interface TaskRepository extends BaseRepository<TaskDao> {

    TaskDao save(TaskDao taskDao);

    Optional<TaskDao> get(Id id);

    void delete(Id id);

    int size();

    TaskDao generate();

    TaskDao generateAndSave();
}
