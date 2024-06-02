package pl.tkosinski.accountingadmin.domain.user;

import pl.tkosinski.accountingadmin.common.BaseRepository;
import pl.tkosinski.accountingadmin.common.model.Id;

import java.util.Optional;

public interface UserRepository extends BaseRepository<UserDao> {

    UserDao save(UserDao userDao);

    Optional<UserDao> get(Id id);

    Optional<UserDao> getLast();

    void delete(Id id);

    int size();

    UserDao generate();

    UserDao generateAndSave();
}
