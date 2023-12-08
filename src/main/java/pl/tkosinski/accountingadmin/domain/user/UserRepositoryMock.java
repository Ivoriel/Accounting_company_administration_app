package pl.tkosinski.accountingadmin.domain.user;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The purpose of this class is to operate as a mock db during development.
 */

public class UserRepositoryMock implements UserRepository{

    HashMap<Long, UserDao> userDb;

    @Override
    public UserDao save(UserDao userDao) {
        return userDb.put(userDao.getId(), userDao);
    }

    @Override
    public Optional<UserDao> get(long id) {
        return Optional.of(userDb.get(id));
    }

    @Override
    public void delete(long id) {
        userDb.remove(id);
    }

    @Override
    public int size() {
        return userDb.size();
    }

    @Override
    public UserDao generate() {
        return generateUser();
    }

    @Override
    public UserDao generateAndSave() {
        return save(generateUser());
    }

    private UserDao generateUser() {
        return UserDao.builder()
                .id(userDb.size())
                .givenName(generateGivenName())
                .lastName(generateLastName())
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
