package pl.tkosinski.accountingadmin.domain.user;

import lombok.Builder;
import lombok.Getter;
import pl.tkosinski.accountingadmin.common.BaseDao;
import pl.tkosinski.accountingadmin.common.model.FullName;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.common.model.Role;

@Getter
@Builder
public class UserDao extends BaseDao {

    private final Id id;
    private Role role;
    private FullName name;

    public UserDao(Id id, Role role, FullName name) {
        this.id = id;
        this.role = role;
        this.name = name;
    }

    public UserDao editName(FullName name) {
        this.name = name;
        return this;
    }

    public UserDao switchRole(Role role) {
        this.role = role;
        return this;
    }
}
