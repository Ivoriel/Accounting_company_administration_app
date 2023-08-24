package pl.tkosinski.accountingadmin.domain.client

import pl.tkosinski.accountingadmin.domain.address.AddressFacade
import pl.tkosinski.accountingadmin.domain.address.AddressRepositoryMock
import pl.tkosinski.accountingadmin.domain.address.AddressRepositoryMockTest
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

    def "Get"() {
        given:
        var daoToSave = ClientDao.builder()
                .name("nazwa")
                .addressId(1)
                .build()
        var clientId = repository.save(daoToSave).getId()

        when:
        var retrievedDao = repository.get(clientId).get()

        then:
        retrievedDao.name == daoToSave.name
        retrievedDao.addressId == daoToSave.addressId
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