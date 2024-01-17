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

    def "should create and save task"() {
        given:
        var daoToSave = UserDao.builder()
                .id(616)
                .givenName("Teodor")
                .lastName("Nowak")
                .build()

        when:
        var savedDao = repository.save(daoToSave)

        then:
        savedDao.id == daoToSave.id
        savedDao.givenName == daoToSave.givenName
        savedDao.lastName == daoToSave.lastName
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
