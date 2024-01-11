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

    public UserDao(long id, String givenName, String lastName) {
        this.id = id;
        this.givenName = givenName;
        this.lastName = lastName;
    }

    public UserDao edit(String givenName, String lastName) {
        this.givenName = givenName;
        this.lastName = lastName;
        return this;
    }
}
