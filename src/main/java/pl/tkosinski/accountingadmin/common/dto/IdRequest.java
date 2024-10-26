package pl.tkosinski.accountingadmin.common.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.user.dto.UserIdDto;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor(access = PRIVATE, force = true)
public class IdRequest {

    private final UserIdDto userId;
    private final Id id;

    public UserIdDto getUserId() {
        return userId;
    }

    public Id getId() {
        return id;
    }
}
