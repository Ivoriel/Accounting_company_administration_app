package pl.tkosinski.accountingadmin.domain.user.dto


import spock.lang.Specification

import static java.lang.Boolean.FALSE
import static java.lang.Boolean.TRUE
import static pl.tkosinski.accountingadmin.common.model.Role.ADMIN
import static pl.tkosinski.accountingadmin.common.model.Role.CLIENT
import static pl.tkosinski.accountingadmin.common.model.Role.EMPLOYEE

class UserIdDtoTest extends Specification {

    def "should return boolean appropriate for role when checking whether user is admin"() {
        when:
        def dto = new UserIdDto(role)

        then:
        result == dto.isAdmin()

        where:
        role     || result
        ADMIN    || TRUE
        EMPLOYEE || FALSE
        CLIENT   || FALSE
    }

    def "IsEmployee"() {
    }

    def "IsEmployeeOrAdmin"() {
    }

    def "IsClient"() {
    }
}
