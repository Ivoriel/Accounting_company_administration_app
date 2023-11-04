package pl.tkosinski.accountingadmin.domain.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.domain.task.dto.TaskDto;

@Component
@RequiredArgsConstructor
public class TaskFacade {

    private final TaskRepository repository;

    public void save(TaskDto dto) {
        repository.get(dto.getId()).ifPresentOrElse(it -> update(it, dto), () -> create(dto));
    }

    private void update(TaskDao dao, TaskDto dto) {
        repository.save(dao.edit());
    }

    private void create(TaskDto dto) {
        repository.save(TaskDao.builder()
                .id(repository.size())
                .build());
    }
}
