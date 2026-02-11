package pl.tkosinski.accountingadmin.domain.client;

import pl.tkosinski.accountingadmin.common.BaseRepository;
import pl.tkosinski.accountingadmin.common.model.Id;

import java.util.Optional;

interface ClientRepository extends BaseRepository<ClientEntity> {

    ClientEntity save(ClientEntity entity);

    Optional<ClientEntity> get(Id id);

    void delete(Id id);

    int size();

    ClientEntity generate();

    ClientEntity generateAndSave();
}
