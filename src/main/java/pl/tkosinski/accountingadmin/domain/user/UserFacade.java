package pl.tkosinski.accountingadmin.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.domain.user.dto.UserDto;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository repository;

    public void save(UserDto dto) {
        repository.get(dto.getId()).ifPresentOrElse(it -> update(it, dto), () -> create(dto));
    }

    public UserDto get(Long id) {
        return UserMapper.toDto(repository.get(id).orElseThrow(NoSuchElementException::new));
    }

    public void delete(long id) {
        repository.delete(id);
    }

    public UserDto generate() {
        return UserMapper.toDto(repository.generate());
    }

    public UserDto generateAndSave() {
        return UserMapper.toDto(repository.generateAndSave());
    }

    private void create(UserDto dto) {
        repository.save(UserDao.builder()
                .id(repository.size())
                .name(dto.getName())
                .build());
    }

    private void update(UserDao dao, UserDto dto) {
        repository.save(dao.edit(dto.getName()));
    }
}
