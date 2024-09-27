package pl.tkosinski.accountingadmin.domain.task;

import pl.tkosinski.accountingadmin.domain.task.dto.TaskDto;

import static pl.tkosinski.accountingadmin.common.exception.code.Utility.UTILITY_CLASS;

class TaskMapper {

    private TaskMapper() {
        throw new IllegalStateException(UTILITY_CLASS.message);
    }

    public static TaskDto toDto(TaskDao dao) {
        return new TaskDto(dao.getId(), dao.getPerformerId(), dao.getClientCompanyId(), dao.getStart(), dao.getEnd(),
                dao.getTitle(), dao.getComment());
    }
}
