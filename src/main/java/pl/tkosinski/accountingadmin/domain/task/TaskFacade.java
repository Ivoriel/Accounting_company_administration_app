package pl.tkosinski.accountingadmin.domain.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.task.dto.TaskAssignmentDto;
import pl.tkosinski.accountingadmin.domain.task.dto.TaskDto;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class TaskFacade {

    private final TaskRepository repository;

    public void save(TaskDto dto) {
        repository.get(dto.id()).ifPresentOrElse(it -> update(it, dto), () -> create(dto));
    }

    public TaskDto get(Id id) {
        return TaskMapper.toDto(repository.get(id).orElseThrow(NoSuchElementException::new));
    }

    public void delete(Id id) {
        repository.delete(id);
    }

    public TaskDto generate() {
        return TaskMapper.toDto(repository.generate());
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

    private void update(TaskDao dao, TaskDto dto) {
        repository.save(dao.edit(dto.performerId(), dto.clientCompanyId(), dto.start(), dto.end(),
                dto.title(), dto.comment()));
    }

    private void create(TaskDto dto) {
        repository.save(TaskDao.builder()
                .id(Id.ofValue(repository.size()))
                .performerId(dto.performerId())
                .clientCompanyId(dto.clientCompanyId())
                .title(dto.title())
                .comment(dto.comment())
                .start(dto.start())
                .end(dto.end())
                .build());
    }
}
