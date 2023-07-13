package pl.tkosinski.accountingadmin.domain.client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.domain.address.AddressFacade;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The purpose of this class is to operate as a mock db during development.
 */

@Component
@AllArgsConstructor
class ClientRepositoryMock implements ClientRepository {

    HashMap ClientDb;
    AddressFacade addressFacade;

    @PostConstruct
    public void init() {
        populateClientDb();
    }

    @Override
    public ClientDao save(ClientDao clientDao) {
        ClientDb.put(clientDao.getId(), clientDao);
        return clientDao;
    }

    @Override
    public Optional<ClientDao> get(long id) {
        return Optional.of((ClientDao) ClientDb.get(id));
    }

    @Override
    public void delete(long id) {
        ClientDb.remove(id);
    }

    @Override
    public int size() {
        return ClientDb.size();
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
        return new ClientDao(size(), generateName(), addressFacade.generate().getId());
    }

    private String generateName() {

        String[] firstNames = {"Stanisław", "Eustachy", "Janusz", "Maria", "Chryzostom", "Kunegunda", "Genowefa", "Alicja",
                "Justyna", "Grzegorz", "Andrzej", "Anna"};

        String[] lastNames = {"Pędziwiatr", "Krzyżtopór", "Zagłoba", "Makarow", "Kowal", "Anioł", "Kosa", "Młot", "Nowak",
                "żak", "Anonim", "Kot", "Lasek"};

        return firstNames[generateRandomInt(firstNames.length - 1)]
                + " " +
                lastNames[generateRandomInt(lastNames.length - 1)];
    }

    private int generateRandomInt(int max) {
        return ThreadLocalRandom.current().nextInt(0, max +1);
    }

}
