package pl.tkosinski.accountingadmin.domain.user;

import lombok.Getter;
import pl.tkosinski.accountingadmin.common.BaseDao;
import pl.tkosinski.accountingadmin.common.model.FullName;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.common.model.Role;

import static pl.tkosinski.accountingadmin.common.model.Role.ADMIN;
import static pl.tkosinski.accountingadmin.common.model.Role.CLIENT;
import static pl.tkosinski.accountingadmin.common.model.Role.EMPLOYEE;

@Getter
class UserDao extends BaseDao {

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

    public void switchRoleToEmployee() {
        this.role = EMPLOYEE;
    }

    public void switchRoleToClient() {
        this.role = CLIENT;
    }

    public void switchRoleToAdmin() {
        this.role = ADMIN;
    }
}
