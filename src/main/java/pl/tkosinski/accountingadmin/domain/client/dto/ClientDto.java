package pl.tkosinski.accountingadmin.domain.client.dto;

import pl.tkosinski.accountingadmin.common.model.FullName;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.user.dto.UserIdDto;

public record ClientDto (UserIdDto userId, Id id, FullName name, Id addressId) {}
