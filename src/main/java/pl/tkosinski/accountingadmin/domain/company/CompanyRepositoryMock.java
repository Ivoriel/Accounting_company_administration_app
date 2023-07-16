package pl.tkosinski.accountingadmin.domain.company;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.domain.address.AddressFacade;
import pl.tkosinski.accountingadmin.domain.client.ClientFacade;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The purpose of this class is to operate as a mock db during development.
 */

@Component
@AllArgsConstructor
class CompanyRepositoryMock implements CompanyRepository{

    HashMap CompanyDb;
    AddressFacade addressFacade;
    ClientFacade clientFacade;


    @PostConstruct
    public void init() {
        populateCompanyDb();
    }

    @Override
    public CompanyDao save(CompanyDao companyDao) {
        CompanyDb.put(companyDao.getId(), companyDao);
        return companyDao;
    }

    @Override
    public Optional<CompanyDao> get(long id) {
        return Optional.ofNullable((CompanyDao) CompanyDb.get(id));
    }

    @Override
    public void delete(long id) {
        CompanyDb.remove(id);
    }

    @Override
    public int size() {
        return CompanyDb.size();
    }

    @Override
    public CompanyDao generate() {
        return generateCompany();
    }

    @Override
    public CompanyDao generateAndSave() {
        return save(generateCompany());
    }

    private CompanyDao generateCompany() {
        return new CompanyDao(size(), generateCompanyName(), clientFacade.generate().getId(),
                addressFacade.generate().getId());
    }

    private void populateCompanyDb() {
        for (long i = 1; i < 10; i++) {
            CompanyDb.put(i, generateAndSave());
        }
    }

    private String generateCompanyName() {
        String[] names = {"Januszex Janusz Typowy", "PolExport sp. z o.o.", "BiznesEx s.c.", "PolBiznes SA",
                "ExKosmos s.j.", "Mydło i Powidło Jan Nowak", "Warzywa i owoca Ewelina Bluszcz", "PHU Kliper s.c.",
                "Story-Train Bill Smith", "Gilgamesh sp. z o.o.", "Enkidu SA", "HusariaPol Marian Kmieć"};
        return names[generateRandomInt(names.length - 1)];
    }

    private int generateRandomInt(int max) {
        return ThreadLocalRandom.current().nextInt(0, max +1);
    }

}
