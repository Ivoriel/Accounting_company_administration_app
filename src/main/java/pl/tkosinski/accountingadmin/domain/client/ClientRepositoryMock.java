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

    HashMap<Id, ClientEntity> clientDb;
    AddressFacade addressFacade;

    @PostConstruct
    public void init() {
        populateClientDb();
    }

    @Override
    public ClientEntity save(ClientEntity entity) {
        clientDb.put(entity.getId(), entity);
        return clientDb.get(entity.getId());
    }

    @Override
    public Optional<ClientEntity> get(Id id) {
        return Optional.ofNullable(clientDb.get(id));
    }

    @Override
    public void delete(Id id) {
        clientDb.remove(id);
    }

    @Override
    public int size() {
        return clientDb.size();
    }

    public ClientEntity generate() {
        return generateClient();
    }

    public ClientEntity generateAndSave() {
        return save(generateClient());
    }

    private void populateClientDb() {
        for (int i = 1; i < 10; i++) {
            generateAndSave();
        }
    }

    private ClientEntity generateClient() {
        return ClientEntity.builder()
                .id(Id.generate())
                .name(FullNameGenerator.generate())
                .addressId(addressFacade.getRequestedOrGenerateAndSave(Id.generate()).id())
                .build();
    }
}
