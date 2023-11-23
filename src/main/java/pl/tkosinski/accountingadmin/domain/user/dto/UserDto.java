package pl.tkosinski.accountingadmin.domain.user.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserDto {

    long id;
    String givenName;
    String lastName;
}
