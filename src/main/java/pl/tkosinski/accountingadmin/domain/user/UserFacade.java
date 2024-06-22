package pl.tkosinski.accountingadmin.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.common.model.FullName;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.user.dto.UserDto;
import pl.tkosinski.accountingadmin.domain.user.service.RoleSwitcher;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository repository;

    private final RoleSwitcher switcher;

    public void save(UserDto dto) {
        repository.get(dto.getId()).ifPresentOrElse(it -> update(it, dto), () -> create(dto));
    }

    public void editName(Id id, FullName name) {
        repository.editName(id, name);
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

    public UserDto generate() {
        return UserMapper.toDto(repository.generate());
    }

    public UserDto generateAndSave() {
        return UserMapper.toDto(repository.generateAndSave());
    }

    private void create(UserDto dto) {
        repository.save(UserDao.builder()
                .id(Id.ofValue(repository.size()))
                .name(dto.getName())
                .build());
    }

    private void update(UserDao dao, UserDto dto) {
        repository.save(dao.editName(dto.getName()));
    }
}
