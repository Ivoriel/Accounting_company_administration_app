package pl.tkosinski.accountingadmin.domain.company;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.common.model.InstitutionName;
import pl.tkosinski.accountingadmin.domain.address.AddressFacade;
import pl.tkosinski.accountingadmin.domain.client.ClientFacade;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The purpose of this class is to operate as a mock db during development.
 */

@Component
@AllArgsConstructor
class CompanyRepositoryMock implements CompanyRepository{

    HashMap<Id, CompanyDao> companyDb;
    AddressFacade addressFacade;
    ClientFacade clientFacade;

    @PostConstruct
    public void init() {
        populateCompanyDb();
    }

    @Override
    public CompanyDao save(CompanyDao companyDao) {
        companyDb.put(companyDao.getId(), companyDao);
        return companyDb.get(companyDao.getId());
    }

    @Override
    public Optional<CompanyDao> get(Id id) {
        return Optional.ofNullable(companyDb.get(id));
    }

    @Override
    public void delete(Id id) {
        companyDb.remove(id);
    }

    @Override
    public int size() {
        return companyDb.size();
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
        return CompanyDao.builder()
                .id(Id.generate())
                .name(generateCompanyName())
                .clientId(clientFacade.getRequestedOrGenerateAndSave(Id.generate()).id())
                .addressId(addressFacade.getRequestedOrGenerateAndSave(Id.generate()).id())
                .build();
    }

    private void populateCompanyDb() {
        for (long i = 1; i < 10; i++) {
            generateAndSave();
        }
    }

    private InstitutionName generateCompanyName() {
        String[] names = {"Januszex Janusz Typowy", "PolExport sp. z o.o.", "BiznesEx s.c.", "PolBiznes SA",
                "ExKosmos s.j.", "Mydło i Powidło Jan Nowak", "Warzywa i owoca Ewelina Bluszcz", "PHU Kliper s.c.",
                "Story-Train Bill Smith", "Gilgamesh sp. z o.o.", "Enkidu SA", "HusariaPol Marian Kmieć"};
        return InstitutionName.ofValue(names[generateRandomInt(names.length - 1)]);
    }

    private int generateRandomInt(int max) {
        return ThreadLocalRandom.current().nextInt(0, max +1);
    }

}
