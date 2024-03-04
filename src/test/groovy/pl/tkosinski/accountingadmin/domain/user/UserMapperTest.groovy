package pl.tkosinski.accountingadmin.domain.user


import pl.tkosinski.accountingadmin.domain.sample.UsesUserSample
import spock.lang.Specification

class UserMapperTest extends Specification implements UsesUserSample {

    UserMapper mapper = new UserMapper()

    def "should map user dao to dto"() {
        def dao = userDaoSample().build()

        when:
        def dto = mapper.toDto(dao)

        then:
        dto.id == dao.id
        dto.name == dao.name
    }
}
