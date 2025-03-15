package pl.tkosinski.accountingadmin.domain.client;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.common.generator.FullNameGenerator;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.address.AddressFacade;

import java.util.HashMap;
import java.util.Optional;

/**
 * The purpose of this class is to operate as a mock db during development.
 */

@Component
@AllArgsConstructor
class ClientRepositoryMock implements ClientRepository {

    HashMap<Id, ClientDao> clientDb;
    AddressFacade addressFacade;

    @PostConstruct
    public void init() {
        populateClientDb();
    }

    @Override
    public ClientDao save(ClientDao clientDao) {
        clientDb.put(clientDao.getId(), clientDao);
        return clientDb.get(clientDao.getId());
    }

    @Override
    public Optional<ClientDao> get(Id id) {
        return Optional.of(clientDb.get(id));
    }

    @Override
    public Optional<ClientDao> getLast() {
        return Optional.ofNullable(clientDb.get(Id.ofValue(size())));
    }

    @Override
    public void delete(Id id) {
        clientDb.remove(id);
    }

    @Override
    public int size() {
        return clientDb.size();
    }

    public ClientDao generate() {
        return generateClient();
    }

    public ClientDao generateAndSave() {
        return save(generateClient());
    }

    private void populateClientDb() {
        for (int i = 1; i < 10; i++) {
            generateAndSave();
        }
    }

    private ClientDao generateClient() {
        return ClientDao.builder()
                .id(Id.ofValue(size()))
                .name(FullNameGenerator.generate())
                .addressId(addressFacade.getRequestedOrGenerateAndSave(Id.ofValue(size())).id())
                .build();
    }
}
