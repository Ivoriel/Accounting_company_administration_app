package pl.tkosinski.accountingadmin.client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kosinski.acaa_dao.Address.AddressRepository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The purpose of this class is to operate as a mock db during development.
 */

@Component
@AllArgsConstructor
public class ClientRepositoryMock implements ClientRepository {

    AddressRepository addressRepository;

    HashMap ClientDb;

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

    private void populateClientDb() {
        for (long i = 1; i < 10; i++) {
            generateClient(i);
        }
    }

    public ClientDao generate() {
        return generateClient(ClientDb.size());
    }

    private ClientDao generateClient(long id) {
        ClientDao dao = new ClientDao(id, generateName(), generateAddressId());
        return dao;
    }

    private String generateName() {
        StringBuilder name = new StringBuilder();

        String[] firstNames = {"Stanisław", "Eustachy", "Janusz", "Maria", "Chryzostom", "Kunegunda", "Genowefa", "Alicja",
                "Justyna", "Grzegorz", "Andrzej", "Anna"};
        name.append(firstNames[generateRandomInt(0, firstNames.length - 1)]);

        String[] lastNames = {"Pędziwiatr", "Krzyżtopór", "Zagłoba", "Makarow", "Kowal", "Anioł", "Kosa", "Młot", "Nowak",
                "żak", "Anonim", "Kot", "Lasek"};
        name.append(lastNames[generateRandomInt(0, lastNames.length - 1)]);

        return name.toString();
    }

    private int generateAddressId() {
        return generateRandomInt(0, addressRepository.size() - 1);
    }

    private int generateRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max +1);
    }

}
