package pl.tkosinski.accountingadmin.domain.user;

import java.util.Optional;

public class UserRepositoryMock implements UserRepository{
    @Override
    public UserDao save(UserDao userDao) {
        return null;
    }

    @Override
    public Optional<UserDao> get(long id) {
        return Optional.empty();
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public UserDao generate() {
        return null;
    }

    @Override
    public UserDao generateAndSave() {
        return null;
    }
}
