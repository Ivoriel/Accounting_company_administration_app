package pl.tkosinski.accountingadmin.domain.task;

import pl.tkosinski.accountingadmin.domain.task.dto.TaskDto;

import static pl.tkosinski.accountingadmin.common.exception.code.Utility.UTILITY_CLASS;

class TaskMapper {

    private TaskMapper() {
        throw new IllegalStateException(UTILITY_CLASS.message);
    }

    public static TaskDto toDto(TaskEntity dao) {
        return new TaskDto(
                dao.getId(),
                dao.getPerformerId(),
                dao.getClientCompanyId(),
                dao.getPeriod(),
                dao.getTitle(),
                dao.getComment());
    }

    public static TaskEntity toDao(TaskDto dto) {
        return new TaskEntity(
                dto.id(),
                dto.performerId(),
                dto.clientCompanyId(),
                dto.period(),
                dto.title(),
                dto.comment());
    }
}
