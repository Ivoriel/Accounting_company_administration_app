package pl.tkosinski.accountingadmin.common;

import pl.tkosinski.accountingadmin.common.model.Id;

import java.util.Optional;

public interface BaseRepository<T extends BaseEntity> {

    T save(T dao);

    Optional<T> get(Id id);

    void delete(Id id);

    int size();

    T generate();

    T generateAndSave();
}
