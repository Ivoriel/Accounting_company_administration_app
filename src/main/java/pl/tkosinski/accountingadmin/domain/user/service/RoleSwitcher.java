package pl.tkosinski.accountingadmin.domain.user.service;

import pl.tkosinski.accountingadmin.common.model.Id;

public interface RoleSwitcher {

    void switchRoleToEmployee(Id userId);

    void switchRoleToClient(Id userId);
}
