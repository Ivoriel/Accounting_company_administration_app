package pl.tkosinski.accountingadmin.domain.company

import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.domain.address.AddressFacade
import pl.tkosinski.accountingadmin.domain.client.ClientFacade
import pl.tkosinski.accountingadmin.domain.sample.UsesAddressSample
import pl.tkosinski.accountingadmin.domain.sample.UsesClientSample
import pl.tkosinski.accountingadmin.domain.sample.UsesCompanySample
import spock.lang.Shared
import spock.lang.Specification

class CompanyRepositoryMockTest extends Specification implements
        UsesCompanySample,
        UsesAddressSample,
        UsesClientSample {

    @Shared
    AddressFacade addressFacade = Stub()
    @Shared
    ClientFacade clientFacade = Stub()
    CompanyRepository repository = new CompanyRepositoryMock(new HashMap(), addressFacade, clientFacade)

    def setupSpec() {
        addressFacade.getRequestedOrGenerateAndSave(_ as Id) >> addressDtoSample().build()
        clientFacade.getRequestedOrGenerateAndSave(_ as Id) >> clientDtoSample()
    }

    def "should generate initial db when instance is created"() {
        when:
        repository.init()

        then:
        repository.size() > 0
    }

    def "should create and save company"() {
        given:
        var companyToSave = companyDaoSample().build()

        when:
        var savedDao = repository.save(companyToSave)

        then:
        savedDao.name == companyToSave.name
        savedDao.addressId == companyToSave.addressId
        savedDao.clientId == companyToSave.clientId
    }

    def "should get company"() {
        given:
        var companyToSave = companyDaoSample().build()
        var savedDaoId = repository.save(companyToSave).id

        when:
        var retrievedDao = repository.get(savedDaoId).get()

        then:
        retrievedDao.name == companyToSave.name
        retrievedDao.addressId == companyToSave.addressId
        retrievedDao.clientId == companyToSave.clientId
    }

    def "should delete company"() {
        given:
        var companyToSave = companyDaoSample().build()
        var savedDaoId = repository.save(companyToSave).id

        when:
        repository.delete(savedDaoId)

        then:
        repository.companyDb.isEmpty()
    }

    def "should return repository size"() {
        when:
        repository.save(companyDaoSample().build())

        then:
        repository.size() == 1
    }

    def "should generate and return company"() {
        when:
        def generatedDao = repository.generate()

        then:
        generatedDao.name != null
    }

    def "should generate and save company"() {
        given:
        def generatedDao = repository.generateAndSave()

        when:
        def retrievedDao = repository.get(generatedDao.id).get()

        then:
        retrievedDao.name == generatedDao.name
        retrievedDao.addressId == generatedDao.addressId
        retrievedDao.clientId == generatedDao.clientId
    }
}
