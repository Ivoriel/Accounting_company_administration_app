package pl.tkosinski.accountingadmin.domain.user;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.common.generator.FullNameGenerator;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.user.dto.UserNameRequest;

import java.util.HashMap;
import java.util.Optional;

import static pl.tkosinski.accountingadmin.common.model.Role.EMPLOYEE;

/**
 * The purpose of this class is to operate as a mock db during development.
 */

@Component
@AllArgsConstructor
class UserRepositoryMock implements UserRepository{

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
    public UserDao editName(UserNameRequest request) {
        return userDb.get(request.id()).editName(request.name());
    }

    @Override
    public Optional<UserDao> get(Id id) {
        return Optional.of(userDb.get(id));
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
        return new UserDao(Id.generate(), EMPLOYEE, FullNameGenerator.generate());
    }
}
