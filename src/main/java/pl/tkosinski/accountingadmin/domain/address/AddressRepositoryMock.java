package pl.tkosinski.accountingadmin.domain.address;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.common.model.Id;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The purpose of this class is to operate as a mock db during development.
 */

@Component
@AllArgsConstructor
class AddressRepositoryMock implements AddressRepository{

    HashMap<Id, AddressDao> addressDb;

    @PostConstruct
    public void init() {
        populateAddressDb();
    }

    @Override
    public AddressDao save(AddressDao addressDao) {
        addressDb.put(addressDao.getId(), addressDao);
        return addressDb.get(addressDao.getId());
    }

    @Override
    public Optional<AddressDao> get(Id id) {
        return Optional.ofNullable(addressDb.get(id));
    }

    @Override
    public void delete(Id id) {
        addressDb.remove(id);
    }

    @Override
    public int size() {
        return addressDb.size();
    }

    private void populateAddressDb(){
        for (int i = 1; i < 10; i++) {
            generateAndSave();
        }
    }

    public AddressDao generate() {
        return generateAddress();
    }

    public AddressDao generateAndSave() {
        return save(generate());
    }

    private AddressDao generateAddress() {
        return new AddressDao(Id.ofValue(size()), generateCountry(), generateMunicipality(), generateRegion(),
                generateZipCode(), generateStreet(), generateBuildingNumber(), generateAdditionalIdentifier());
    }

    private String generateCountry() {
        return "Polska";
    }

    private String generateMunicipality() {
        String[] municipalities = {"Toruń", "Płock", "Lubicz", "Warszawa", "Sosnowiec", "Ostrołęka", "Żywiec", "Modlin",
                                    "Inowrocław", "Głogowo"};
        return municipalities[generateRandomInt(0, municipalities.length - 1)];
    }

    private String generateRegion() {
        String[] regions = {"Kujawsko-Pomorskie", "Mazowieckie", "Śląskie"};
        return regions[generateRandomInt(0, regions.length - 1)];
    }

    private String generateZipCode() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            if (i == 2) {
                sb.append("-");
            } else {
                sb.append(generateRandomInt(0, 9));
            }
        }
        return sb.toString();
    }

    private String generateStreet() {
        String[] streets = {"Prosta", "Szeroka", "Długa", "Mickiewicza", "Slowackiego", "Solidarności", "Grodzka",
                            "Bohaterów Mariupola", "Wiśniowa", "Kochanowskiego", "Leśna"};
        return streets[generateRandomInt(0,9)];
    }

    private String generateBuildingNumber() {
        StringBuilder sb = new StringBuilder();
        int buildingNumber = generateRandomInt(1, 115);
        sb.append(buildingNumber);
        if (buildingNumber % 4 == 0 || buildingNumber % 7 == 0) {
            sb.append("A");
            return sb.toString();
        }
        if (buildingNumber % 9 == 0) {
            sb.append("B");
            return sb.toString();
        }
        return sb.toString();
    }

    private String generateAdditionalIdentifier() {
        StringBuilder sb = new StringBuilder();
        int additionalIdentifier = generateRandomInt(1, 156);
        sb.append(additionalIdentifier);
        if (additionalIdentifier % 7 == 0) {
            sb.append("Piętro 1");
            return sb.toString();
        }
        if (additionalIdentifier % 9 == 0) {
            sb.append("Piętro 3");
            return sb.toString();
        }
        return sb.toString();
    }

    private int generateRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max +1);
    }

}
