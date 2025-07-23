package pl.tkosinski.accountingadmin.domain.company

import pl.tkosinski.accountingadmin.domain.sample.UsesCompanySample
import spock.lang.Specification

class CompanyMapperTest extends Specification implements UsesCompanySample{

    def "should not allow creating CompanyMapper object"() {
        when:
        new CompanyMapper()

        then:
        thrown(IllegalStateException.class)
    }

    def "should map company entity to dto"() {
        def entity = companyEntitySample().build()

        when:
        def dto = CompanyMapper.toDto(entity)

        then:
        dto.id == entity.id
        dto.name == entity.name
        dto.addressId == entity.addressId
        dto.clientId == entity.clientId
    }
}
