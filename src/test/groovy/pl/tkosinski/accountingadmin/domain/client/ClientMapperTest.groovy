package pl.tkosinski.accountingadmin.domain.client

import pl.tkosinski.accountingadmin.domain.sample.UsesClientSample
import spock.lang.Specification

class ClientMapperTest extends Specification implements UsesClientSample {

    def "should not allow creating TaskMapper object"() {
        when:
        new ClientMapper()

        then:
        thrown(IllegalStateException.class)
    }

    def "should map client entity to dto"() {
        given:
        def dao = clientDaoSample().build()

        when:
        def dto = ClientMapper.toDto(dao)

        then:
        dto.id == dao.id
        dto.name == dao.name
        dto.addressId == dao.addressId
    }
}
