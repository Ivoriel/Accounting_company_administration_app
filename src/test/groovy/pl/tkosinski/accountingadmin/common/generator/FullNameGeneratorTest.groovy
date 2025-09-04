package pl.tkosinski.accountingadmin.common.generator

import pl.tkosinski.accountingadmin.domain.address.AddressMapper
import spock.lang.Specification

class FullNameGeneratorTest extends Specification {

    def "should not allow creating FullNameGenerator object"() {
        when:
        new FullNameGenerator()

        then:
        thrown(IllegalStateException.class)
    }

    def "should generate FullName object with given and last name attributes"() {
        when:
        def generated = FullNameGenerator.generate()

        then:
        verifyAll {
            generated.givenName instanceof String
            generated.lastName instanceof String
            generated.otherIdentifier == null
        }
    }
}
