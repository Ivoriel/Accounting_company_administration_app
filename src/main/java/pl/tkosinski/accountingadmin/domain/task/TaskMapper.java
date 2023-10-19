package pl.tkosinski.accountingadmin.domain.task;

import pl.tkosinski.accountingadmin.domain.task.dto.TaskDto;

public class TaskMapper {

    public static TaskDto toDto(TaskDao dao) {
        return TaskDto.builder()
                .id(dao.getId())
                .build();
    }
}
