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
        def dataToSave = addressEntitySample().build()

        when:
        def savedData = repository.save(dataToSave)

        then:
        savedData.country == dataToSave.country
        savedData.municipality == dataToSave.municipality
        savedData.region == dataToSave.region
        savedData.zipCode == dataToSave.zipCode
        savedData.street == dataToSave.street
        savedData.buildingNumber == dataToSave.buildingNumber
        savedData.additionalIdentifier == dataToSave.additionalIdentifier
    }

    def "should get address"() {
        given:
        def dataToSave = addressEntitySample().build()
        def addressId = repository.save(dataToSave).id

        when:
        def retrievedData = repository.get(addressId).get()

        then:
        retrievedData.country == dataToSave.country
        retrievedData.municipality == dataToSave.municipality
        retrievedData.region == dataToSave.region
        retrievedData.zipCode == dataToSave.zipCode
        retrievedData.street == dataToSave.street
        retrievedData.buildingNumber == dataToSave.buildingNumber
        retrievedData.additionalIdentifier == dataToSave.additionalIdentifier
    }

    def "should delete address"() {
        given:
        def dataToSave = addressEntitySample().build()
        def addressId = repository.save(dataToSave).id

        when:
        repository.delete(addressId)

        then:
        repository.addressDb.isEmpty()
    }

    def "should return repository size"() {
        when:
        repository.save(addressEntitySample().build())

        then:
        repository.size() == 1
    }

    def "should generate and return address"() {
        when:
        def generatedEntity = repository.generate()

        then:
        generatedEntity.country != null
        generatedEntity.municipality != null
        generatedEntity.region != null
        generatedEntity.zipCode != null
        generatedEntity.street != null
        generatedEntity.buildingNumber != null
        generatedEntity.additionalIdentifier != null
    }

    def "should generate and save address"() {
        given:
        def generatedEntity = repository.generateAndSave()

        when:
        def retrievedEntity = repository.get(generatedEntity.id).get()

        then:
        retrievedEntity.country == generatedEntity.country
        retrievedEntity.municipality == generatedEntity.municipality
        retrievedEntity.region == generatedEntity.region
        retrievedEntity.zipCode == generatedEntity.zipCode
        retrievedEntity.street == generatedEntity.street
        retrievedEntity.buildingNumber == generatedEntity.buildingNumber
        retrievedEntity.additionalIdentifier == generatedEntity.additionalIdentifier
    }
}
