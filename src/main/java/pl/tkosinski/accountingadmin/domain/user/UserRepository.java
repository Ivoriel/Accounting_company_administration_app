package pl.tkosinski.accountingadmin.domain.user;

import pl.tkosinski.accountingadmin.common.BaseRepository;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.user.dto.UserNameRequest;

import java.util.Optional;

interface UserRepository extends BaseRepository<UserEntity> {

    UserEntity save(UserEntity entity);

    UserEntity editName(UserNameRequest request);

    Optional<UserEntity> get(Id id);

    void delete(Id id);

    int size();

    UserEntity generate();

    UserEntity generateAndSave();
}
