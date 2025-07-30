package pl.tkosinski.accountingadmin.domain.user

import spock.lang.Specification

class UserGeneratorTest extends Specification {

    def "should generate and return user"() {
        given:
        def generator = new UserGenerator()

        when:
        def generatedDto = generator.generate()

        then:
        generatedDto.name != null
    }
}