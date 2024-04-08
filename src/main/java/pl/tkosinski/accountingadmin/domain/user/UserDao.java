package pl.tkosinski.accountingadmin.domain.user;

import lombok.Builder;
import lombok.Getter;
import pl.tkosinski.accountingadmin.common.BaseDao;
import pl.tkosinski.accountingadmin.common.model.FullName;
import pl.tkosinski.accountingadmin.common.model.Id;

@Getter
@Builder
public class UserDao extends BaseDao {

    private final Id id;
    private FullName name;

    public UserDao(Id id, FullName name) {
        this.id = id;
        this.name = name;
    }

    public UserDao edit(FullName name) {
        this.name = name;
        return this;
    }
}
