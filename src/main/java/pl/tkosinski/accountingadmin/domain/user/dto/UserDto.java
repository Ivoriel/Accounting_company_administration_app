package pl.tkosinski.accountingadmin.domain.user.dto;

import lombok.Builder;
import lombok.Value;
import pl.tkosinski.accountingadmin.common.model.FullName;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.common.model.Role;

@Value
@Builder
public class UserDto {

    Id id;
    Role role;
    FullName name;
}
