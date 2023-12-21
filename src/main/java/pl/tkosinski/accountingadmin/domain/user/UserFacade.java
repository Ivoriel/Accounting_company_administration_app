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

    private void create(UserDto dto) {
        repository.save(UserDao.builder()
                .id(repository.size())
                .givenName(dto.getGivenName())
                .lastName(dto.getLastName())
                .build());
    }

    private void update(UserDao dao, UserDto dto) {
        repository.save(dao.edit(dto.getGivenName(), dto.getLastName()));
    }
}
