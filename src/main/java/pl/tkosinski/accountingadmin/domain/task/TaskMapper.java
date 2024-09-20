package pl.tkosinski.accountingadmin.domain.task;

import pl.tkosinski.accountingadmin.domain.task.dto.TaskDto;

class TaskMapper {

    public static TaskDto toDto(TaskDao dao) {
        return new TaskDto(dao.getId(), dao.getPerformerId(), dao.getClientCompanyId(), dao.getStart(), dao.getEnd(),
                dao.getTitle(), dao.getComment());
    }
}
