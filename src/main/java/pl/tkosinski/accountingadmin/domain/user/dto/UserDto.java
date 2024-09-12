package pl.tkosinski.accountingadmin.domain.user.dto;

import pl.tkosinski.accountingadmin.common.model.FullName;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.common.model.Role;

public record UserDto(Id id, Role role, FullName name) {

}
