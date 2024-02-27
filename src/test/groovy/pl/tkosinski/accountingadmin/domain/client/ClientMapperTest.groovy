package pl.tkosinski.accountingadmin.domain.client

import pl.tkosinski.accountingadmin.common.FullName
import pl.tkosinski.accountingadmin.domain.sample.UsesClientSample
import spock.lang.Specification

class ClientMapperTest extends Specification implements UsesClientSample {

    ClientMapper mapper = new ClientMapper()

    def "should map client entity to dto"() {
        given:
        def dao = clientDaoSample().build()

        when:
        def dto = mapper.toDto(dao)

        then:
        dto.id == dao.id
        dto.name == dao.name
        dto.addressId == dao.addressId
    }
}
