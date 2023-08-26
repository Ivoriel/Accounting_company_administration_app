package pl.tkosinski.accountingadmin.domain.company

import pl.tkosinski.accountingadmin.domain.address.AddressFacade
import pl.tkosinski.accountingadmin.domain.address.AddressRepositoryMock
import pl.tkosinski.accountingadmin.domain.client.ClientFacade
import pl.tkosinski.accountingadmin.domain.client.ClientRepositoryMock
import spock.lang.Specification

class CompanyRepositoryMockTest extends Specification {

    AddressFacade addressFacade = new AddressFacade(new AddressRepositoryMock(new HashMap()))
    CompanyRepository repository = new CompanyRepositoryMock(new HashMap(), addressFacade,
            new ClientFacade(new ClientRepositoryMock(new HashMap(), addressFacade)))

    def "Init"() {
    }

    def "should create and save company"() {
        given:
        var companyToSave = CompanyDao.builder()
                .name("company test name")
                .clientId(1)
                .addressId(1)
                .build()

        when:
        var savedDao = repository.save(companyToSave)

        then:
        savedDao.name == companyToSave.name
        savedDao.addressId == companyToSave.addressId
        savedDao.clientId == companyToSave.clientId
    }

    def "Get"() {
    }

    def "Delete"() {
    }

    def "Size"() {
    }

    def "Generate"() {
    }

    def "GenerateAndSave"() {
    }
}
