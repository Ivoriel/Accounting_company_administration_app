package pl.tkosinski.accountingadmin.api;

import pl.tkosinski.accountingadmin.domain.user.dto.UserIdDto;

public class BaseController {

    protected void validateAdmin(UserIdDto userId) {
        if (!userId.isAdmin()) {
            throw new UnsupportedOperationException("Admin privileges required for this operation");
        }
    }

    protected void validateEmployee(UserIdDto userId) {
        if (!userId.isEmployee()) {
            throw new UnsupportedOperationException("Employee privileges required for this operation");
        }
    }

    protected void validateAdminOrEmployee(UserIdDto userId) {
        if (!userId.isEmployeeOrAdmin()) {
            throw new UnsupportedOperationException("Admin or Employee privileges required for this operation");
        }
    }

    protected void validateClient(UserIdDto userId) {
        if (!userId.isClient()) {
            throw new UnsupportedOperationException("Client privileges required for this operation");
        }
    }

    protected void validateAuthorized(UserIdDto userId) {
        if (!userId.isAuthorized()) {
            throw new UnsupportedOperationException("Authorized user privileges required for this operation");
        }
    }
}
