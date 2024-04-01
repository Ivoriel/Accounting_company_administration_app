package pl.tkosinski.accountingadmin.domain.user.dto;

import lombok.Builder;
import lombok.Value;
import pl.tkosinski.accountingadmin.common.FullName;
import pl.tkosinski.accountingadmin.common.model.Id;

@Value
@Builder
public class UserDto {

    Id id;
    FullName name;
}
