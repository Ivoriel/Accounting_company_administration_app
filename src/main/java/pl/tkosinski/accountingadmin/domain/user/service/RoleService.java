package pl.tkosinski.accountingadmin.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.user.UserDao;
import pl.tkosinski.accountingadmin.domain.user.UserRepository;

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
}
