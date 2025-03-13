package pl.tkosinski.accountingadmin.common.model

import spock.lang.Specification

class FullNameTest extends Specification {


    def "should throw exception when given and last name parameters are null"() {
        given:
        def name = FullName.ofValue(null, null)

        when:
        name.validate()

        then:
        thrown(UnsupportedOperationException)
    }

    def "Validate"() {
    }
}
