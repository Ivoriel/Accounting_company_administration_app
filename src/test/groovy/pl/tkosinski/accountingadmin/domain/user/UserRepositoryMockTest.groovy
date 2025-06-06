package pl.tkosinski.accountingadmin.domain.user

import pl.tkosinski.accountingadmin.common.model.FullName
import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.domain.sample.UsesUserSample
import pl.tkosinski.accountingadmin.domain.user.dto.UserIdDto
import pl.tkosinski.accountingadmin.domain.user.dto.UserNameRequest
import spock.lang.Specification

import static pl.tkosinski.accountingadmin.common.model.Role.EMPLOYEE

class UserRepositoryMockTest extends Specification implements UsesUserSample {

    UserRepository repository = new UserRepositoryMock(new HashMap<Id, UserEntity>())

    def "should generate initial db when instance is created"() {
        when:
        repository.init()

        then:
        repository.size() > 0
    }

    def "should create and save task"() {
        given:
        var daoToSave = userDaoSample().build()

        when:
        var savedDao = repository.save(daoToSave)

        then:
        savedDao.id == daoToSave.id
        savedDao.name == daoToSave.name
    }

    def "should retrieve user"() {
        given:
        var daoToSave = userDaoSample().build()
        var userId = repository.save(daoToSave).id

        when:
        var retrievedDao = repository.get(userId).get()

        then:
        retrievedDao.name == daoToSave.name
    }

    def "should edit name of user"() {
        given:
        var daoToSave = userDaoSample().build()
        var name = daoToSave.getName()
        var userId = repository.save(daoToSave).id

        when:
        var retrievedDao = repository.editName(new UserNameRequest(new UserIdDto(EMPLOYEE), userId, FullName.ofValue("differentFirstname", "differentLastName")))

        then:
        retrievedDao.name != name
    }

    def "should delete user"() {
        given:
        var daoToSave = userDaoSample().build()
        var userId = repository.save(daoToSave).id

        when:
        repository.delete(userId)

        then:
        repository.userDb.isEmpty()
    }

    def "should return repository size"() {
        when:
        repository.save(userDaoSample().build())

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
