package pl.tkosinski.accountingadmin.domain.address

import pl.tkosinski.accountingadmin.domain.sample.UsesAddressSample
import spock.lang.Specification

class AddressRepositoryMockTest extends Specification implements UsesAddressSample {

    AddressRepository repository = new AddressRepositoryMock(new HashMap())

    def "should generate initial db when instance is created"() {
        when:
        repository.init()

        then:
        repository.size() > 0
    }

    def "should create address"() {
        given:
        def daoToSave = addressDaoSample().build()

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
        def daoToSave = addressDaoSample().build()
        def addressId = repository.save(daoToSave).id

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

    def "should get last address"() {
        given:
        def firstDaoToSave = addressDaoSample(id: 1).build()
        repository.save(firstDaoToSave)
        def secondDaoToSave = addressDaoSample(id: 2).build()
        repository.save(secondDaoToSave)
        def thirdDaoToSave = addressDaoSample(id: 3).build()
        repository.save(thirdDaoToSave)

        when:
        def retrievedDao = repository.getLast().get()

        then:
        retrievedDao.id != firstDaoToSave.id
        retrievedDao.id != secondDaoToSave.id
        retrievedDao.id == thirdDaoToSave.id
    }

    def "should delete address"() {
        given:
        def daoToSave = addressDaoSample().build()
        def addressId = repository.save(daoToSave).id

        when:
        repository.delete(addressId)

        then:
        repository.addressDb.isEmpty()
    }

    def "should return repository size"() {
        when:
        repository.save(addressDaoSample().build())

        then:
        repository.size() == 1
    }

    def "should generate and return address"() {
        when:
        def generatedDao = repository.generate()

        then:
        generatedDao.country != null
        generatedDao.municipality != null
        generatedDao.region != null
        generatedDao.zipCode != null
        generatedDao.street != null
        generatedDao.buildingNumber != null
        generatedDao.additionalIdentifier != null
    }

    def "should generate and save address"() {
        given:
        def generatedDao = repository.generateAndSave()

        when:
        def retrievedDao = repository.get(generatedDao.id).get()

        then:
        retrievedDao.country == generatedDao.country
        retrievedDao.municipality == generatedDao.municipality
        retrievedDao.region == generatedDao.region
        retrievedDao.zipCode == generatedDao.zipCode
        retrievedDao.street == generatedDao.street
        retrievedDao.buildingNumber == generatedDao.buildingNumber
        retrievedDao.additionalIdentifier == generatedDao.additionalIdentifier
    }
}
