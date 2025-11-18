package pl.tkosinski.accountingadmin.domain.user;

import pl.tkosinski.accountingadmin.common.model.Id;

interface RoleSwitcher {

    void switchRoleToEmployee(Id userId);

    void switchRoleToClient(Id userId);

    void switchRoleToClientAdmin(Id userId);

    void switchRoleToAdmin(Id userId);
}
