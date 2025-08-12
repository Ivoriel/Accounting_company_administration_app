package pl.tkosinski.accountingadmin.domain.task.dto;

import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.user.dto.UserRoleDto;

public record TaskAssignmentDto(UserRoleDto userDto, Id taskId, Id performerId) {}
