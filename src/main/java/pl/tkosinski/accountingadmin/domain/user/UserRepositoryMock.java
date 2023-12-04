package pl.tkosinski.accountingadmin.domain.user;

import java.util.HashMap;
import java.util.Optional;

public class UserRepositoryMock implements UserRepository{

    HashMap<Long, UserDao> userDb;

    @Override
    public UserDao save(UserDao userDao) {
        return userDb.put(userDao.getId(), userDao);
    }

    @Override
    public Optional<UserDao> get(long id) {
        return Optional.of(userDb.get(id));
    }

    @Override
    public void delete(long id) {
        userDb.remove(id);
    }

    @Override
    public int size() {
        return userDb.size();
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
