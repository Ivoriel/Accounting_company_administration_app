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

    def "should get company"() {
        given:
        var companyToSave = CompanyDao.builder()
                .name("company test name")
                .clientId(1)
                .addressId(1)
                .build()
        var savedDaoId = repository.save(companyToSave).getId()

        when:
        var retrievedDao = repository.get(savedDaoId).get()

        then:
        retrievedDao.name == companyToSave.name
        retrievedDao.addressId == companyToSave.addressId
        retrievedDao.clientId == companyToSave.clientId
    }

    def "should delete company"() {
        given:
        var companyToSave = CompanyDao.builder()
                .name("company test name")
                .clientId(1)
                .addressId(1)
                .build()
        var savedDaoId = repository.save(companyToSave).getId()

        when:
        repository.delete(savedDaoId)

        then:
        repository.CompanyDb.isEmpty()
    }

    def "should return repository size"() {
        when:
        repository.save(CompanyDao.builder()
                .name("company test name")
                .clientId(1)
                .addressId(1)
                .build())

        then:
        repository.size() == 1
    }

    def "should generate and return company"() {
        when:
        def generatedDao = repository.generate()

        then:
        generatedDao.name != null
    }

    def "GenerateAndSave"() {
    }
}
