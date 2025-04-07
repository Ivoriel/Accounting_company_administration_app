package pl.tkosinski.accountingadmin.domain.client;

import pl.tkosinski.accountingadmin.common.BaseRepository;
import pl.tkosinski.accountingadmin.common.model.Id;

import java.util.Optional;

interface ClientRepository extends BaseRepository<ClientDao> {

    ClientDao save(ClientDao clientDao);

    Optional<ClientDao> get(Id id);

    void delete(Id id);

    int size();

    ClientDao generate();

    ClientDao generateAndSave();
}
