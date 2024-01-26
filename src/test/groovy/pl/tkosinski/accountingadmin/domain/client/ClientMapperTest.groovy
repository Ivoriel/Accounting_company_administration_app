package pl.tkosinski.accountingadmin.domain.client

import spock.lang.Specification

class ClientMapperTest extends Specification {

    ClientMapper mapper = new ClientMapper()

    def "should map client entity to dto"() {
        given:
        def dao = ClientDao.builder()
                .id(16)
                .givenName("Teodor")
                .lastName("Nowak")
                .addressId(165)
                .build()

        when:
        def dto = mapper.toDto(dao)

        then:
        dto.id == dao.id
        dto.givenName == dao.givenName
        dto.lastName == dao.lastName
        dto.addressId == dao.addressId
    }
}
