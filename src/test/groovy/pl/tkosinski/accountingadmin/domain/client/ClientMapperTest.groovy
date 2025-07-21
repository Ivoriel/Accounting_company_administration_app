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
        def entity = clientEntitySample().build()

        when:
        def dto = ClientMapper.toDto(entity)

        then:
        dto.id == entity.id
        dto.name == entity.name
        dto.addressId == entity.addressId
    }
}
