package pl.tkosinski.accountingadmin.domain.task;

import pl.tkosinski.accountingadmin.domain.task.dto.TaskDto;

import static pl.tkosinski.accountingadmin.common.exception.code.Utility.UTILITY_CLASS;

class TaskMapper {

    private TaskMapper() {
        throw new IllegalStateException(UTILITY_CLASS.message);
    }

    public static TaskDto toDto(TaskEntity entity) {
        return new TaskDto(
                entity.getId(),
                entity.getPerformerId(),
                entity.getClientCompanyId(),
                entity.getPeriod(),
                entity.getTitle(),
                entity.getComment());
    }

    public static TaskEntity toEntity(TaskDto dto) {
        return new TaskEntity(
                dto.id(),
                dto.performerId(),
                dto.clientCompanyId(),
                dto.period(),
                dto.title(),
                dto.comment());
    }
}
