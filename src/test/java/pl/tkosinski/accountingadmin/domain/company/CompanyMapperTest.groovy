package pl.tkosinski.accountingadmin.domain.company

import spock.lang.Specification

class CompanyMapperTest extends Specification {

    CompanyMapper mapper = new CompanyMapper()

    def "should map company entity to dto"() {
        def dao = CompanyDao.builder()
                .id(616)
                .name("Test company name")
                .addressId(919)
                .clientId(818)
                .build()

        when:
        def dto = mapper.toDto(dao)

        then:
        dto.id == dao.id
        dto.name == dao.name
        dto.addressId == dao.addressId
        dto.clientId == dao.clientId
    }
}
