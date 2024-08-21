package pl.tkosinski.accountingadmin.domain.task.dto;

import pl.tkosinski.accountingadmin.common.model.Id;

public class TaskAssignmentDto {

    private final Id taskId;
    private final Id performerId;

    public TaskAssignmentDto(Id taskId, Id performerId) {
        this.taskId = taskId;
        this.performerId = performerId;
    }

    public Id getTaskId() {
        return taskId;
    }

    public Id getPerformerId() {
        return performerId;
    }
}
