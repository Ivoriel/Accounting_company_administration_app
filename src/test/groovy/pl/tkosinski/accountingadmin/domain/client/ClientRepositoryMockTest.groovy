package pl.tkosinski.accountingadmin.domain.client

import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.domain.address.AddressFacade
import pl.tkosinski.accountingadmin.domain.sample.UsesAddressSample
import pl.tkosinski.accountingadmin.domain.sample.UsesClientSample
import spock.lang.Shared
import spock.lang.Specification

class ClientRepositoryMockTest extends Specification implements UsesClientSample, UsesAddressSample{

    @Shared
    AddressFacade addressFacade = Stub()
    ClientRepository repository = new ClientRepositoryMock(new HashMap(), addressFacade)

    def setupSpec() {
        addressFacade.getRequestedOrGenerateAndSave(_ as Id) >> addressDtoSample()
    }

    def "should generate initial db when instance is created"() {
        when:
        repository.init()

        then:
        repository.size() > 0
    }

    def "should create client"() {
        given:
        var dataToSave = clientEntitySample().build()

        when:
        var savedData = repository.save(dataToSave)

        then:
        savedData.name == dataToSave.name
        savedData.addressId == dataToSave.addressId
    }

    def "should get client"() {
        given:
        var dataToSave = clientEntitySample().build()
        var clientId = repository.save(dataToSave).id

        when:
        var retrievedData = repository.get(clientId).get()

        then:
        retrievedData.name == dataToSave.name
        retrievedData.addressId == dataToSave.addressId
    }

    def "should delete client"() {
        given:
        var dataToSave = clientEntitySample().build()
        var clientId = repository.save(dataToSave).id

        when:
        repository.delete(clientId)

        then:
        repository.clientDb.isEmpty()
    }

    def "should return repository size"() {
        when:
        repository.save(clientEntitySample().build())

        then:
        repository.size() == 1
    }

    def "should generate and return client"() {
        when:
        def generatedEntity = repository.generate()

        then:
        generatedEntity.name != null
    }

    def "should generate and return saved client"() {
        given:
        def generatedEntity = repository.generateAndSave()

        when:
        def retrievedEntity = repository.get(generatedEntity.id).get()

        then:
        retrievedEntity.name == generatedEntity.name
        retrievedEntity.addressId == generatedEntity.addressId
    }
}
