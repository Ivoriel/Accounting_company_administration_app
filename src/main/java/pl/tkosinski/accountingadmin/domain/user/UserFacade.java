package pl.tkosinski.accountingadmin.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.common.model.FullName;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.user.dto.UserDto;
import pl.tkosinski.accountingadmin.domain.user.dto.UserNameRequest;
import pl.tkosinski.accountingadmin.domain.user.dto.UserRequest;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository repository;

    private final RoleSwitcher switcher;

    public void save(UserRequest request) {
        repository.get(request.id()).ifPresentOrElse(it -> update(it, request), () -> create(request));
    }

    public void editName(UserNameRequest request) {
        repository.editName(request);
    }

    public UserDto get(Id id) {
        return UserMapper.toDto(repository.get(id).orElseThrow(NoSuchElementException::new));
    }

    public UserDto getRequestedOrGenerateAndSave(Id id) {
        return UserMapper.toDto(repository.get(id).orElse(repository.generateAndSave()));
    }

    public void delete(Id id) {
        repository.delete(id);
    }

    public void switchRoleToEmployee(Id id) {
        switcher.switchRoleToEmployee(id);
    }

    public void switchRoleToClient(Id id) {
        switcher.switchRoleToClient(id);
    }

    public void switchRoleToAdmin(Id id) {
        switcher.switchRoleToAdmin(id);
    }

    public UserDto generate() {
        return UserMapper.toDto(repository.generate());
    }

    public UserDto generateAndSave() {
        return UserMapper.toDto(repository.generateAndSave());
    }

    private void create(UserRequest request) {
        repository.save(new UserDao(Id.ofValue(repository.size()), request));
    }

    private void update(UserDao dao, UserRequest request) {
        repository.save(dao.editName(request.name()));
    }
}
