package pl.tkosinski.accountingadmin.domain.task;

import pl.tkosinski.accountingadmin.common.BaseRepository;

import java.util.Optional;

public interface TaskRepository extends BaseRepository<TaskDao> {

    TaskDao save(TaskDao taskDao);

    Optional<TaskDao> get(long id);

    void delete(long id);

    int size();

    TaskDao generate();

    TaskDao generateAndSave();
}
