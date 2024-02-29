package pl.tkosinski.accountingadmin.domain.company

import pl.tkosinski.accountingadmin.domain.sample.UsesCompanySample
import spock.lang.Specification

class CompanyMapperTest extends Specification implements UsesCompanySample{

    CompanyMapper mapper = new CompanyMapper()

    def "should map company entity to dto"() {
        def dao = companyDaoSample().build()

        when:
        def dto = mapper.toDto(dao)

        then:
        dto.id == dao.id
        dto.name == dao.name
        dto.addressId == dao.addressId
        dto.clientId == dao.clientId
    }
}
