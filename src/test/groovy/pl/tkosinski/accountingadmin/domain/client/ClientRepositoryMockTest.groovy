package pl.tkosinski.accountingadmin.domain.client

import pl.tkosinski.accountingadmin.domain.address.AddressFacade
import pl.tkosinski.accountingadmin.domain.address.AddressRepositoryMock
import spock.lang.Specification

class ClientRepositoryMockTest extends Specification {

    ClientRepository repository = new ClientRepositoryMock(new HashMap(), new AddressFacade(new AddressRepositoryMock(
            new HashMap())))

    def "should generate initial db when instance is created"() {
        when:
        repository.init()

        then:
        repository.size() > 0
    }

    def "should create client"() {
        given:
        var daoToSave = ClientDao.builder()
                .givenName("Teodor")
                .lastName("Nowak")
                .addressId(1)
                .build()

        when:
        var savedDao = repository.save(daoToSave)

        then:
        savedDao.givenName == daoToSave.givenName
        savedDao.lastName == daoToSave.lastName
        savedDao.addressId == daoToSave.addressId
    }

    def "should get client"() {
        given:
        var daoToSave = ClientDao.builder()
                .givenName("Teodor")
                .lastName("Nowak")
                .addressId(1)
                .build()
        var clientId = repository.save(daoToSave).id

        when:
        var retrievedDao = repository.get(clientId).get()

        then:
        retrievedDao.givenName == daoToSave.givenName
        retrievedDao.lastName = daoToSave.lastName
        retrievedDao.addressId == daoToSave.addressId
    }

    def "should delete client"() {
        given:
        var daoToSave = ClientDao.builder()
                .givenName("Teodor")
                .lastName("Nowak")
                .addressId(1)
                .build()
        var clientId = repository.save(daoToSave).id

        when:
        repository.delete(clientId)

        then:
        repository.clientDb.isEmpty()
    }

    def "should return repository size"() {
        when:
        repository.save(ClientDao.builder()
                .givenName("Teodor")
                .lastName("Nowak")
                .addressId(1)
                .build())

        then:
        repository.size() == 1
    }

    def "should generate and return client"() {
        when:
        def generatedDao = repository.generate()

        then:
        generatedDao.givenName != null
        generatedDao.lastName != null
    }

    def "should generate and return saved client"() {
        given:
        def generatedDao = repository.generateAndSave()

        when:
        def retrievedDao = repository.get(generatedDao.id).get()

        then:
        retrievedDao.givenName == generatedDao.givenName
        retrievedDao.lastName == generatedDao.lastName
        retrievedDao.addressId == generatedDao.addressId
    }
}
