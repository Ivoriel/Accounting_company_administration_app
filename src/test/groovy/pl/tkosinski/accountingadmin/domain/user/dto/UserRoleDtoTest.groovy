package pl.tkosinski.accountingadmin.domain.user.dto


import spock.lang.Specification

import static java.lang.Boolean.FALSE
import static java.lang.Boolean.TRUE
import static pl.tkosinski.accountingadmin.common.model.Role.ADMIN
import static pl.tkosinski.accountingadmin.common.model.Role.CLIENT
import static pl.tkosinski.accountingadmin.common.model.Role.CLIENT_ADMIN
import static pl.tkosinski.accountingadmin.common.model.Role.EMPLOYEE

class UserRoleDtoTest extends Specification {

    def "should return boolean appropriate for role when checking whether user is an administrator"() {
        when:
        def dto = new UserRoleDto(role)

        then:
        result == dto.isAdmin()

        where:
        role     || result
        ADMIN    || TRUE
        EMPLOYEE || FALSE
        CLIENT   || FALSE
    }

    def "should return boolean appropriate for role when checking whether user is an employee"() {
        when:
        def dto = new UserRoleDto(role)

        then:
        result == dto.isEmployee()

        where:
        role     || result
        ADMIN    || FALSE
        EMPLOYEE || TRUE
        CLIENT   || FALSE
    }

    def "should return boolean appropriate for role when checking whether user is an employee or admin"() {
        when:
        def dto = new UserRoleDto(role)

        then:
        result == dto.isEmployeeOrAdmin()

        where:
        role     || result
        ADMIN    || TRUE
        EMPLOYEE || TRUE
        CLIENT   || FALSE
    }

    def "should return boolean appropriate for role when checking whether user is a client"() {
        when:
        def dto = new UserRoleDto(role)

        then:
        result == dto.isClient()

        where:
        role         || result
        ADMIN        || FALSE
        EMPLOYEE     || FALSE
        CLIENT_ADMIN || TRUE
        CLIENT       || TRUE
    }

    def "should return boolean appropriate for role when checking whether user is a client administrator"() {
        when:
        def dto = new UserRoleDto(role)

        then:
        result == dto.isClientAdmin()

        where:
        role         || result
        ADMIN        || FALSE
        EMPLOYEE     || FALSE
        CLIENT_ADMIN || TRUE
        CLIENT       || FALSE
    }
}
