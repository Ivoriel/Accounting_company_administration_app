package pl.tkosinski.accountingadmin.domain.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.company.CompanyFacade;
import pl.tkosinski.accountingadmin.domain.task.dto.TaskAssignmentDto;
import pl.tkosinski.accountingadmin.domain.task.dto.TaskDto;
import pl.tkosinski.accountingadmin.domain.task.dto.TaskRequest;
import pl.tkosinski.accountingadmin.domain.user.UserFacade;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class TaskFacade {

    private final TaskRepository repository;
    private final UserFacade userFacade;
    private final CompanyFacade companyFacade;

    public void save(TaskRequest request) {
        repository.get(request.id()).ifPresentOrElse(it -> update(it, request), () -> create(request));
    }

    public TaskDto get(Id id) {
        return TaskMapper.toDto(repository.get(id).orElseThrow(NoSuchElementException::new));
    }

    public void delete(Id id) {
        repository.delete(id);
    }

    public TaskDto generate() {
        return new TaskGenerator().generate(userFacade, companyFacade);
    }

    public TaskDto generateAndSave() {
        return TaskMapper.toDto(repository.generateAndSave());
    }

    public void assignTask(TaskAssignmentDto dto) {
        repository.assignTask(dto);
    }

    public void beginTask(Id taskId) {
        repository.beginTask(taskId);
    }

    public void finishTask(Id taskId) {
        repository.finishTask(taskId);
    }

    private void update(TaskDao dao, TaskRequest request) {
        repository.save(dao.edit(request));
    }

    private void create(TaskRequest request) {
        repository.save(new TaskDao(Id.generate(), request));
    }
}
