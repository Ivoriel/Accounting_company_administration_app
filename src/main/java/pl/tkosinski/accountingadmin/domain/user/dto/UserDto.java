package pl.tkosinski.accountingadmin.domain.user.dto;

import lombok.Builder;
import lombok.Value;
import pl.tkosinski.accountingadmin.common.FullName;

@Value
@Builder
public class UserDto {

    long id;
    FullName name;
}
