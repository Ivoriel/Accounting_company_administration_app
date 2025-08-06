package pl.tkosinski.accountingadmin.common.api;

import pl.tkosinski.accountingadmin.domain.user.dto.UserRoleDto;

public class BaseController {

    protected void validateAdmin(UserRoleDto userId) {
        if (!userId.isAdmin()) {
            throw new UnsupportedOperationException("Admin privileges required for this operation");
        }
    }

    protected void validateEmployee(UserRoleDto userId) {
        if (!userId.isEmployee()) {
            throw new UnsupportedOperationException("Employee privileges required for this operation");
        }
    }

    protected void validateAdminOrEmployee(UserRoleDto userId) {
        if (!userId.isEmployeeOrAdmin()) {
            throw new UnsupportedOperationException("Admin or Employee privileges required for this operation");
        }
    }

    protected void validateClient(UserRoleDto userId) {
        if (!userId.isClient()) {
            throw new UnsupportedOperationException("Client privileges required for this operation");
        }
    }

    protected void validateAuthorized(UserRoleDto userId) {
        if (!userId.isAuthorized()) {
            throw new UnsupportedOperationException("Authorized user privileges required for this operation");
        }
    }
}
