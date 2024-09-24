package pl.tkosinski.accountingadmin.domain.task.dto;

import pl.tkosinski.accountingadmin.common.model.Id;

public record TaskAssignmentDto(Id taskId, Id performerId) {}
