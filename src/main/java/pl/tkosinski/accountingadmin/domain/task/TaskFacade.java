package pl.tkosinski.accountingadmin.domain.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.domain.task.dto.TaskDto;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class TaskFacade {

    private final TaskRepository repository;

    public void save(TaskDto dto) {
        repository.get(dto.getId()).ifPresentOrElse(it -> update(it, dto), () -> create(dto));
    }

    public TaskDto get(Long id) {
        return TaskMapper.toDto(repository.get(id).orElseThrow(NoSuchElementException::new));
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public TaskDto generate() {
        return TaskMapper.toDto(repository.generate());
    }

    public TaskDto generateAndSave() {
        return TaskMapper.toDto(repository.generateAndSave());
    }

    private void update(TaskDao dao, TaskDto dto) {
        repository.save(dao.edit(dto.getStart(), dto.getEnd(), dto.getComment()));
    }

    private void create(TaskDto dto) {
        repository.save(TaskDao.builder()
                .id(repository.size())
                .build());
    }
}
