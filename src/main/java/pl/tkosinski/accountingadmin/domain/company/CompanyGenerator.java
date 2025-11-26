package pl.tkosinski.accountingadmin.domain.company;

import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.common.model.InstitutionName;
import pl.tkosinski.accountingadmin.domain.address.AddressFacade;
import pl.tkosinski.accountingadmin.domain.client.ClientFacade;
import pl.tkosinski.accountingadmin.domain.company.dto.CompanyDto;

import java.util.concurrent.ThreadLocalRandom;

class CompanyGenerator {

    CompanyDto generate(ClientFacade clientFacade, AddressFacade addressFacade) {
        return generate(clientFacade.generateAndSave().id(), addressFacade.generateAndSave().id());
    }

    CompanyDto generate(Id clientId, Id addressId) {
        return new CompanyDto(
                Id.generate(),
                generateCompanyName(),
                clientId,
                addressId);
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