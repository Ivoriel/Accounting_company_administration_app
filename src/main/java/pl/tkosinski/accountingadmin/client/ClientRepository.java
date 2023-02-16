package pl.tkosinski.accountingadmin.client;

import pl.kosinski.acaa_dao.Common.BaseRepository;

import java.util.Optional;

public interface ClientRepository extends BaseRepository {

    ClientDao save(ClientDao clientDao);

    Optional<ClientDao> get(long id);

    void delete(long id);

    int size();

    ClientDao generate();

}
