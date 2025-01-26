package pl.tkosinski.accountingadmin.domain.address

import pl.tkosinski.accountingadmin.domain.sample.UsesAddressSample
import spock.lang.Specification

class AddressMapperTest extends Specification implements UsesAddressSample {

    def "should not allow creating TaskMapper object"() {
        when:
        new AddressMapper()

        then:
        thrown(IllegalStateException.class)
    }

    def "should map address entity to dto"() {
        def dao = addressDaoSample().build()

        when:
        def dto = AddressMapper.toDto(dao)

        then:
        dto.id == dao.id
        dto.country == dao.country
        dto.municipality == dao.municipality
        dto.region == dao.region
        dto.zipCode == dao.zipCode
        dto.street == dao.street
        dto.buildingNumber == dao.buildingNumber
        dto.additionalIdentifier == dao.additionalIdentifier
    }
}
