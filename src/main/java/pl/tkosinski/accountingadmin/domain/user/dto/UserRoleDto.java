package pl.tkosinski.accountingadmin.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pl.tkosinski.accountingadmin.common.model.Role;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static pl.tkosinski.accountingadmin.common.model.Role.ADMIN;
import static pl.tkosinski.accountingadmin.common.model.Role.CLIENT;
import static pl.tkosinski.accountingadmin.common.model.Role.EMPLOYEE;

@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor(access = PRIVATE, force = true)
public class UserRoleDto {

    private static final List<Role> INTERNAL_ROLES = List.of(ADMIN, EMPLOYEE);
    private static final List<Role> AUTHORIZED_ROLES = List.of(ADMIN, EMPLOYEE, CLIENT);

    private final Role role;

    public boolean isAdmin() {
        return ADMIN == role;
    }

    public boolean isEmployee() {
        return EMPLOYEE == role;
    }

    public boolean isEmployeeOrAdmin() {
        return INTERNAL_ROLES.contains(role);
    }

    public boolean isClient() {
        return CLIENT == role;
    }

    public boolean isAuthorized() {
        return AUTHORIZED_ROLES.contains(role);
    }
}
