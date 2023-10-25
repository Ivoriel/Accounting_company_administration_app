package pl.tkosinski.accountingadmin.domain.client;

import pl.tkosinski.accountingadmin.common.BaseRepository;

import java.util.Optional;

interface ClientRepository extends BaseRepository<ClientDao> {

    ClientDao save(ClientDao clientDao);

    Optional<ClientDao> get(long id);

    void delete(long id);

    int size();

    ClientDao generate();

    ClientDao generateAndSave();
}
