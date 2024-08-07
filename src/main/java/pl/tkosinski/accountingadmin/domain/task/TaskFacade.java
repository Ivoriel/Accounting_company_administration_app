package pl.tkosinski.accountingadmin.domain.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.task.dto.TaskDto;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class TaskFacade {

    private final TaskRepository repository;

    public void save(TaskDto dto) {
        repository.get(dto.getId()).ifPresentOrElse(it -> update(it, dto), () -> create(dto));
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

    private void update(TaskDao dao, TaskDto dto) {
        repository.save(dao.edit(dto.getPerformerId(), dto.getStart(), dto.getEnd(), dto.getTitle(), dto.getComment()));
    }

    private void create(TaskDto dto) {
        repository.save(TaskDao.builder()
                .id(Id.ofValue(repository.size()))
                .build());
    }
}
