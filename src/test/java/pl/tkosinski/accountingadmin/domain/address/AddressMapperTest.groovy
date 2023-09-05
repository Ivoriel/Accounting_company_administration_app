package pl.tkosinski.accountingadmin.domain.address

import spock.lang.Specification

class AddressMapperTest extends Specification {

    AddressMapper mapper = new AddressMapper()

    def "should map address entity to dto"() {
        def dao = AddressDao.builder()
                .id(17)
                .country("Polska")
                .municipality("Toruń")
                .region("kujawsko-pomorskie")
                .zipCode("87-100")
                .street("Jasna")
                .buildingNumber("1")
                .additionalIdentifier("2p")
                .build()

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
