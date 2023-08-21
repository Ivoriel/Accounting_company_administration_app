package pl.tkosinski.accountingadmin.domain.address

import pl.tkosinski.accountingadmin.domain.address.dto.AddressDto
import spock.lang.Specification

class AddressRepositoryMockTest extends Specification {

    AddressRepository repository = new AddressRepositoryMock(new HashMap())

    def "Init"() {
    }

    def "should create address"() {
        given:
        def daoToSave = AddressDao.builder()
                .country("Polska")
                .municipality("Toruń")
                .region("kujawsko-pomorskie")
                .zipCode("87-100")
                .street("Jasna")
                .buildingNumber("1")
                .additionalIdentifier("2p")
                .build()

        when:
        def savedDao = repository.save(daoToSave)

        then:
        savedDao.country == daoToSave.country
        savedDao.municipality == daoToSave.municipality
        savedDao.region == daoToSave.region
        savedDao.zipCode == daoToSave.zipCode
        savedDao.street == daoToSave.street
        savedDao.buildingNumber == daoToSave.buildingNumber
        savedDao.additionalIdentifier == daoToSave.additionalIdentifier
    }

    def "should get address"() {
        given:
        def daoToSave = AddressDao.builder()
                .country("Polska")
                .municipality("Toruń")
                .region("kujawsko-pomorskie")
                .zipCode("87-100")
                .street("Jasna")
                .buildingNumber("1")
                .additionalIdentifier("2p")
                .build()
        def addressId = repository.save(daoToSave).getId()

        when:
        def retrievedDao = repository.get(addressId).get()

        then:
        retrievedDao.country == daoToSave.country
        retrievedDao.municipality == daoToSave.municipality
        retrievedDao.region == daoToSave.region
        retrievedDao.zipCode == daoToSave.zipCode
        retrievedDao.street == daoToSave.street
        retrievedDao.buildingNumber == daoToSave.buildingNumber
        retrievedDao.additionalIdentifier == daoToSave.additionalIdentifier
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
