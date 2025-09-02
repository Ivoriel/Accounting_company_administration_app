package pl.tkosinski.accountingadmin.domain.address

import pl.tkosinski.accountingadmin.domain.sample.UsesAddressSample
import spock.lang.Specification

class AddressMapperTest extends Specification implements UsesAddressSample {

    def "should not allow creating AddressMapper object"() {
        when:
        new AddressMapper()

        then:
        thrown(IllegalStateException.class)
    }

    def "should map address entity to dto"() {
        def entity = addressEntitySample().build()

        when:
        def dto = AddressMapper.toDto(entity)

        then:
        dto.id == entity.id
        dto.country == entity.country
        dto.municipality == entity.municipality
        dto.region == entity.region
        dto.zipCode == entity.zipCode
        dto.street == entity.street
        dto.buildingNumber == entity.buildingNumber
        dto.additionalIdentifier == entity.additionalIdentifier
    }
}
