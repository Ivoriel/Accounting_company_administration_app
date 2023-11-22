package pl.tkosinski.accountingadmin.domain.user;

import lombok.Builder;
import lombok.Getter;
import pl.tkosinski.accountingadmin.common.BaseDao;

@Getter
@Builder
public class UserDao extends BaseDao {

    private final long id;
    private String givenName;
    private String lastName;
}
