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
        def entity = userEntitySample().build()

        when:
        def dto = UserMapper.toDto(entity)

        then:
        dto.id == entity.id
        dto.role == entity.role
        dto.name == entity.name
    }
}
