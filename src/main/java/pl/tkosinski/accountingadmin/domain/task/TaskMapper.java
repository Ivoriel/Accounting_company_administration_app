package pl.tkosinski.accountingadmin.domain.task;

import pl.tkosinski.accountingadmin.domain.task.dto.TaskDto;

class TaskMapper {

    public static TaskDto toDto(TaskDao dao) {
        return TaskDto.builder()
                .id(dao.getId())
                .performerId(dao.getPerformerId())
                .start(dao.getStart())
                .end(dao.getEnd())
                .comment(dao.getComment())
                .build();
    }
}
