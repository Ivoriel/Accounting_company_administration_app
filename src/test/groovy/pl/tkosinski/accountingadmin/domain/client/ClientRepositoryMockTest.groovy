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
        addressFacade.getRequestedOrGenerateAndSave(_ as Id) >> addressDtoSample().build()
    }

    def "should generate initial db when instance is created"() {
        when:
        repository.init()

        then:
        repository.size() > 0
    }

    def "should create client"() {
        given:
        var daoToSave = clientEntitySample().build()

        when:
        var savedDao = repository.save(daoToSave)

        then:
        savedDao.name == daoToSave.name
        savedDao.addressId == daoToSave.addressId
    }

    def "should get client"() {
        given:
        var daoToSave = clientEntitySample().build()
        var clientId = repository.save(daoToSave).id

        when:
        var retrievedDao = repository.get(clientId).get()

        then:
        retrievedDao.name == daoToSave.name
        retrievedDao.addressId == daoToSave.addressId
    }

    def "should delete client"() {
        given:
        var daoToSave = clientEntitySample().build()
        var clientId = repository.save(daoToSave).id

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
        def generatedDao = repository.generate()

        then:
        generatedDao.name != null
    }

    def "should generate and return saved client"() {
        given:
        def generatedDao = repository.generateAndSave()

        when:
        def retrievedDao = repository.get(generatedDao.id).get()

        then:
        retrievedDao.name == generatedDao.name
        retrievedDao.addressId == generatedDao.addressId
    }
}
