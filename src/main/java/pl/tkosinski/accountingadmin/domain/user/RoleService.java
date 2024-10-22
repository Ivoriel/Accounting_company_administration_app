package pl.tkosinski.accountingadmin.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tkosinski.accountingadmin.common.model.Id;

@Service
@RequiredArgsConstructor
class RoleService implements RoleSwitcher {

    private final UserRepository repository;

    @Override
    public void switchRoleToEmployee(Id userId) {
        repository.get(userId).ifPresent(UserDao::switchRoleToEmployee);
    }

    @Override
    public void switchRoleToClient(Id userId) {
        repository.get(userId).ifPresent(UserDao::switchRoleToClient);
    }

    @Override
    public void switchRoleToAdmin(Id userId) {
        repository.get(userId).ifPresent(UserDao::switchRoleToAdmin);
    }
}
