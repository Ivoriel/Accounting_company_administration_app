package pl.tkosinski.accountingadmin.domain.client

import pl.tkosinski.accountingadmin.domain.address.AddressFacade
import pl.tkosinski.accountingadmin.domain.address.AddressRepositoryMock
import spock.lang.Specification

class ClientRepositoryMockTest extends Specification {

    ClientRepository repository = new ClientRepositoryMock(new HashMap(), new AddressFacade(new AddressRepositoryMock(
            new HashMap())))

    def "Init"() {
    }

    def "should create client"() {
        given:
        var daoToSave = ClientDao.builder()
                .name("nazwa")
                .addressId(1)
                .build()

        when:
        var savedDao = repository.save(daoToSave)

        then:
        savedDao.name == daoToSave.name
        savedDao.addressId == daoToSave.addressId
    }

    def "should get client"() {
        given:
        var daoToSave = ClientDao.builder()
                .name("nazwa")
                .addressId(1)
                .build()
        var clientId = repository.save(daoToSave).id

        when:
        var retrievedDao = repository.get(clientId).get()

        then:
        retrievedDao.name == daoToSave.name
        retrievedDao.addressId == daoToSave.addressId
    }

    def "should delete client"() {
        given:
        var daoToSave = ClientDao.builder()
                .name("nazwa")
                .addressId(1)
                .build()
        var clientId = repository.save(daoToSave).id

        when:
        repository.delete(clientId)

        then:
        repository.ClientDb.isEmpty()
    }

    def "should return repository size"() {
        when:
        repository.save(ClientDao.builder()
                .name("nazwa")
                .addressId(1)
                .build())

        then:
        repository.size() == 1
    }

    def "should generate and return client"() {
        when:
        def generatedDao = repository.generate()

        then:
        generatedDao.name != null
    }

    def "GenerateAndSave"() {
        given:
        def generatedDao = repository.generateAndSave()

        when:
        def retrievedDao = repository.get(generatedDao.id).get()

        then:
        retrievedDao.name == generatedDao.name
        retrievedDao.addressId == generatedDao.addressId
    }
}
