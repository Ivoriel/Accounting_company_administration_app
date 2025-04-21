package pl.tkosinski.accountingadmin.domain.address.generator;

import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.address.dto.AddressDto;

import java.util.concurrent.ThreadLocalRandom;

public class AddressGenerator {

    private static final String COUNTRY = "Polska";

    public AddressDto generate() {
        return new AddressDto(Id.generate(), generateCountry(), generateMunicipality(), generateRegion(),
                generateZipCode(), generateStreet(), generateBuildingNumber(), generateAdditionalIdentifier());
    }

    private String generateCountry() {
        return COUNTRY;
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
