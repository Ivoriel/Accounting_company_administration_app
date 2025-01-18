package pl.tkosinski.accountingadmin.domain.user.dto;

import pl.tkosinski.accountingadmin.common.model.FullName;
import pl.tkosinski.accountingadmin.common.model.Id;

public record UserNameRequest(UserIdDto userId, Id id, FullName name) {}
