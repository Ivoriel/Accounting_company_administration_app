package pl.tkosinski.accountingadmin.domain.user;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.common.generator.FullNameGenerator;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.common.model.Role;

import java.util.HashMap;
import java.util.Optional;

import static pl.tkosinski.accountingadmin.common.model.Role.EMPLOYEE;

/**
 * The purpose of this class is to operate as a mock db during development.
 */

@Component
@AllArgsConstructor
public class UserRepositoryMock implements UserRepository{

    HashMap<Id, UserDao> userDb;

    @PostConstruct
    public void init() {
        populateUserDb();
    }

    @Override
    public UserDao save(UserDao userDao) {
        userDb.put(userDao.getId(), userDao);
        return userDb.get(userDao.getId());
    }

    @Override
    public Optional<UserDao> get(Id id) {
        return Optional.of(userDb.get(id));
    }

    @Override
    public Optional<UserDao> getLast() {
        return Optional.ofNullable(userDb.get(Id.ofValue(size())));
    }

    @Override
    public void delete(Id id) {
        userDb.remove(id);
    }

    @Override
    public int size() {
        return userDb.size();
    }

    @Override
    public UserDao generate() {
        return generateUser();
    }

    @Override
    public UserDao generateAndSave() {
        return save(generateUser());
    }

    private void populateUserDb(){
        for (long i = 1; i < 10; i++) {
            generateAndSave();
        }
    }

    private UserDao generateUser() {
        return UserDao.builder()
                .id(Id.ofValue(userDb.size()))
                .name(FullNameGenerator.generate())
                .role(EMPLOYEE)
                .build();
    }
}
