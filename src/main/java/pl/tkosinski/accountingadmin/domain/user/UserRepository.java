package pl.tkosinski.accountingadmin.domain.user;

import pl.tkosinski.accountingadmin.common.BaseRepository;
import pl.tkosinski.accountingadmin.common.model.FullName;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.user.dto.UserNameRequest;

import java.util.Optional;

interface UserRepository extends BaseRepository<UserDao> {

    UserDao save(UserDao userDao);

    UserDao editName(UserNameRequest request);

    Optional<UserDao> get(Id id);

    void delete(Id id);

    int size();

    UserDao generate();

    UserDao generateAndSave();
}
