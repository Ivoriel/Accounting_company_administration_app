package pl.tkosinski.accountingadmin.domain.address

import pl.tkosinski.accountingadmin.domain.address.dto.AddressDto
import spock.lang.Specification

class AddressRepositoryMockTest extends Specification {

    AddressRepository repository = new AddressRepositoryMock(new HashMap())

    def "Init"() {
    }

    def "should create and get address"() {
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
        def dao = repository.get(savedDao.id).get()

        then:
        savedDao.country == dao.country
        savedDao.municipality == dao.municipality
        savedDao.region == dao.region
        savedDao.zipCode == dao.zipCode
        savedDao.street == dao.street
        savedDao.buildingNumber == dao.buildingNumber
        savedDao.additionalIdentifier == dao.additionalIdentifier
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
