package pl.tkosinski.accountingadmin.domain.user

import pl.tkosinski.accountingadmin.domain.sample.UsesUserSample
import spock.lang.Specification

class UserMapperTest extends Specification implements UsesUserSample {

    def "should not allow creating UserMapper object"() {
        when:
        new UserMapper()

        then:
        thrown(IllegalStateException.class)
    }

    def 'should map user entity to dto'() {
        def dao = userEntitySample().build()

        when:
        def dto = UserMapper.toDto(dao)

        then:
        dto.id == dao.id
        dto.role == dao.role
        dto.name == dao.name
    }
}
