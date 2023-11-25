package pl.tkosinski.accountingadmin.domain.user;

import pl.tkosinski.accountingadmin.common.BaseRepository;

import java.util.Optional;

public interface UserRepository extends BaseRepository<UserDao> {

    UserDao save(UserDao userDao);

    Optional<UserDao> get(long id);

    void delete(long id);

    int size();

    UserDao generate();

    UserDao generateAndSave();
}
