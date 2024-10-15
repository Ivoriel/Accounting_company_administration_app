package pl.tkosinski.accountingadmin.domain.user


import pl.tkosinski.accountingadmin.domain.sample.UsesUserSample
import spock.lang.Specification

class UserMapperTest extends Specification implements UsesUserSample {

    def "should map user dao to dto"() {
        def dao = userDaoSample().build()

        when:
        def dto = UserMapper.toDto(dao)

        then:
        dto.id == dao.id
        dto.role == dao.role
        dto.name == dao.name
    }
}
