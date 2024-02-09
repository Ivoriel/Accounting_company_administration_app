package pl.tkosinski.accountingadmin.common.generator;

import pl.tkosinski.accountingadmin.common.FullName;

import java.util.concurrent.ThreadLocalRandom;

import static pl.tkosinski.accountingadmin.common.exception.code.Utility.UTILITY_CLASS;

public class FullNameGenerator {

    private FullNameGenerator() {
        throw new IllegalStateException(UTILITY_CLASS.message);
    }

    public static FullName generate() {
        String[] firstNames = {"Stanisław", "Eustachy", "Janusz", "Maria", "Chryzostom", "Kunegunda", "Genowefa", "Alicja",
                "Justyna", "Grzegorz", "Andrzej", "Anna"};

        String[] lastNames = {"Pędziwiatr", "Krzyżtopór", "Zagłoba", "Makarow", "Kowal", "Anioł", "Kosa", "Młot", "Nowak",
                "żak", "Anonim", "Kot", "Lasek"};

        return FullName.ofValue(
                firstNames[generateRandomInt(firstNames.length - 1)],
                lastNames[generateRandomInt(lastNames.length - 1)]);
    }

    private static int generateRandomInt(int max) {
        return ThreadLocalRandom.current().nextInt(0, max +1);
    }
}
