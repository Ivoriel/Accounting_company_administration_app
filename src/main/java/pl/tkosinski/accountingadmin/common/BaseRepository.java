package pl.tkosinski.accountingadmin.common;

import java.util.Optional;

public interface BaseRepository<T extends BaseDao> {

    T save(T dao);

    Optional<T> get(long id);

    void delete(long id);

    int size();

    T generate();

    T generateAndSave();
}
