package pl.tkosinski.accountingadmin.domain.user;

import lombok.Builder;
import lombok.Getter;
import pl.tkosinski.accountingadmin.common.BaseDao;
import pl.tkosinski.accountingadmin.common.model.FullName;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.common.model.Role;
import pl.tkosinski.accountingadmin.domain.user.dto.UserRequest;

import static pl.tkosinski.accountingadmin.common.model.Role.ADMIN;
import static pl.tkosinski.accountingadmin.common.model.Role.CLIENT;
import static pl.tkosinski.accountingadmin.common.model.Role.CLIENT_ADMIN;
import static pl.tkosinski.accountingadmin.common.model.Role.EMPLOYEE;

@Getter
@Builder
class UserEntity implements BaseDao {

    private final Id id;
    private Role role;
    private FullName name;

    public UserEntity(Id id, Role role, FullName name) {
        this.id = id;
        this.role = role;
        this.name = name;
    }

    public UserEntity(Id id, UserRequest request) {
        this.id = id;
        this.role = request.role();
        this.name = request.name();
    }

    public UserEntity editName(FullName name) {
        this.name = name;
        return this;
    }

    public void switchRoleToEmployee() {
        this.role = EMPLOYEE;
    }

    public void switchRoleToClient() {
        this.role = CLIENT;
    }

    public void switchRoleToClientAdmin() {
        this.role = CLIENT_ADMIN;
    }

    public void switchRoleToAdmin() {
        this.role = ADMIN;
    }
}
