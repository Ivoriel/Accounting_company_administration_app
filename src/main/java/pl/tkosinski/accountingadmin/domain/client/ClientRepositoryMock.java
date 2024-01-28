package pl.tkosinski.accountingadmin.domain.client;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.domain.address.AddressFacade;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The purpose of this class is to operate as a mock db during development.
 */

@Component
@AllArgsConstructor
class ClientRepositoryMock implements ClientRepository {

    HashMap<Long, ClientDao> clientDb;
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
    public Optional<ClientDao> get(long id) {
        return Optional.of(clientDb.get(id));
    }

    @Override
    public void delete(long id) {
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
        for (long i = 1; i < 10; i++) {
            generateAndSave();
        }
    }

    private ClientDao generateClient() {
        return ClientDao.builder()
                .id(size())
                .givenName(generateGivenName())
                .lastName(generateLastName())
                .addressId(addressFacade.generate().getId())
                .build();
    }

    private String generateGivenName() {

        String[] firstNames = {"Stanisław", "Eustachy", "Janusz", "Maria", "Chryzostom", "Kunegunda", "Genowefa", "Alicja",
                "Justyna", "Grzegorz", "Andrzej", "Anna"};

        return firstNames[generateRandomInt(firstNames.length - 1)];
    }

    private String generateLastName() {
        String[] lastNames = {"Pędziwiatr", "Krzyżtopór", "Zagłoba", "Makarow", "Kowal", "Anioł", "Kosa", "Młot", "Nowak",
                "żak", "Anonim", "Kot", "Lasek"};

        return lastNames[generateRandomInt(lastNames.length - 1)];
    }

    private int generateRandomInt(int max) {
        return ThreadLocalRandom.current().nextInt(0, max +1);
    }

}
