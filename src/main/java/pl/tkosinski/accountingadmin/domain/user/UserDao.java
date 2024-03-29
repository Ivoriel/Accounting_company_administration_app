package pl.tkosinski.accountingadmin.domain.user;

import lombok.Builder;
import lombok.Getter;
import pl.tkosinski.accountingadmin.common.BaseDao;
import pl.tkosinski.accountingadmin.common.FullName;

@Getter
@Builder
public class UserDao extends BaseDao {

    private final long id;
    private FullName name;

    public UserDao(long id, FullName name) {
        this.id = id;
        this.name = name;
    }

    public UserDao edit(FullName name) {
        this.name = name;
        return this;
    }
}
