package pl.tkosinski.accountingadmin.domain.address

import pl.tkosinski.accountingadmin.domain.sample.UsesAddressSample
import spock.lang.Specification

class AddressMapperTest extends Specification implements UsesAddressSample {

    AddressMapper mapper = new AddressMapper()

    def "should map address entity to dto"() {
        def dao = addressDaoSample().build()

        when:
        def dto = mapper.toDto(dao)

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
