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
        def dao = companyEntitySample().build()

        when:
        def dto = CompanyMapper.toDto(dao)

        then:
        dto.id == dao.id
        dto.name == dao.name
        dto.addressId == dao.addressId
        dto.clientId == dao.clientId
    }
}
