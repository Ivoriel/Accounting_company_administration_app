package pl.tkosinski.accountingadmin.domain.user

import pl.tkosinski.accountingadmin.common.FullName
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
                .name(FullName.ofValue("Teodor", "Nowak"))
                .build()

        when:
        var savedDao = repository.save(daoToSave)

        then:
        savedDao.id == daoToSave.id
        savedDao.name == daoToSave.name
    }

    def "should retrieve task"() {
        given:
        var daoToSave = UserDao.builder()
                .id(616)
                .name(FullName.ofValue("Teodor", "Nowak"))
                .build()
        var userId = repository.save(daoToSave).id

        when:
        var retrievedDao = repository.get(userId).get()

        then:
        retrievedDao.name == daoToSave.name
    }

    def "should delete user"() {
        given:
        var daoToSave = UserDao.builder()
                .id(616)
                .name(FullName.ofValue("Teodor", "Nowak"))
                .build()
        var userId = repository.save(daoToSave).id

        when:
        repository.delete(userId)

        then:
        repository.userDb.isEmpty()
    }

    def "should return repository size"() {
        when:
        repository.save(UserDao.builder()
                .id(616)
                .name(FullName.ofValue("Teodor", "Nowak"))
                .build())

        then:
        repository.size() == 1
    }

    def "should generate and return user"() {
        when:
        def generatedDao = repository.generate()

        then:
        generatedDao.name != null
    }

    def "should generate and save user"() {
        given:
        def generatedDao = repository.generateAndSave()

        when:
        def retrievedDao = repository.get(generatedDao.id).get()

        then:
        retrievedDao.name == generatedDao.name
    }
}
