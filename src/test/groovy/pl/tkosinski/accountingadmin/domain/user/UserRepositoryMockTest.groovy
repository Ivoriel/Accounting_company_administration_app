package pl.tkosinski.accountingadmin.domain.user

import spock.lang.Specification

class UserRepositoryMockTest extends Specification {

    UserRepository repository = new UserRepositoryMock(new HashMap<Long, UserDao>())

    def "should generate initial db when instance is created"() {
        when:
        repository.init()

        then:
        repository.size() > 0
    }

    def "Save"() {
    }

    def "Get"() {
    }

    def "Delete"() {
    }

    def "Size"() {
    }

    def "Generate"() {
    }

    def "GenerateAndSave"() {
    }
}
