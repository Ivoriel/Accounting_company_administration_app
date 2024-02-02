package pl.tkosinski.accountingadmin.domain.client

import pl.tkosinski.accountingadmin.common.FullName
import spock.lang.Specification

class ClientMapperTest extends Specification {

    ClientMapper mapper = new ClientMapper()

    def "should map client entity to dto"() {
        given:
        def dao = ClientDao.builder()
                .id(16)
                .name(FullName.ofValue("Teodor", "Nowak"))
                .addressId(165)
                .build()

        when:
        def dto = mapper.toDto(dao)

        then:
        dto.id == dao.id
        dto.name == dao.name
        dto.addressId == dao.addressId
    }
}
