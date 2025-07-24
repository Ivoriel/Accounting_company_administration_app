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
        var companyToSave = companyEntitySample().build()

        when:
        var savedData = repository.save(companyToSave)

        then:
        savedData.name == companyToSave.name
        savedData.addressId == companyToSave.addressId
        savedData.clientId == companyToSave.clientId
    }

    def "should get company"() {
        given:
        var companyToSave = companyEntitySample().build()
        var savedEntityId = repository.save(companyToSave).id

        when:
        var retrievedData = repository.get(savedEntityId).get()

        then:
        retrievedData.name == companyToSave.name
        retrievedData.addressId == companyToSave.addressId
        retrievedData.clientId == companyToSave.clientId
    }

    def "should delete company"() {
        given:
        var companyToSave = companyEntitySample().build()
        var savedEntityId = repository.save(companyToSave).id

        when:
        repository.delete(savedEntityId)

        then:
        repository.companyDb.isEmpty()
    }

    def "should return repository size"() {
        when:
        repository.save(companyEntitySample().build())

        then:
        repository.size() == 1
    }

    def "should generate and return company"() {
        when:
        def generatedEntity = repository.generate()

        then:
        generatedEntity.name != null
    }

    def "should generate and save company"() {
        given:
        def generatedEntity = repository.generateAndSave()

        when:
        def retrievedEntity = repository.get(generatedEntity.id).get()

        then:
        retrievedEntity.name == generatedEntity.name
        retrievedEntity.addressId == generatedEntity.addressId
        retrievedEntity.clientId == generatedEntity.clientId
    }
}
