package pl.tkosinski.accountingadmin.domain.task.dto;

import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.user.dto.UserIdDto;

public record TaskAssignmentDto(UserIdDto userDto, Id taskId, Id performerId) {}
