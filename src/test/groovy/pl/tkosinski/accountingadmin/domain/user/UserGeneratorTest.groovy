package pl.tkosinski.accountingadmin.domain.user

import spock.lang.Specification

class UserGeneratorTest extends Specification {

    def "should generate and return user"() {
        given:
        def generator = new UserGenerator()

        when:
        def generatedDao = generator.generate()

        then:
        generatedDao.name != null
    }
}