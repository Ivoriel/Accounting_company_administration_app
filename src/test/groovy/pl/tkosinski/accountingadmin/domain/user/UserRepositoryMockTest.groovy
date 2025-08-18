package pl.tkosinski.accountingadmin.domain.user

import pl.tkosinski.accountingadmin.common.model.FullName
import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.domain.sample.UsesUserSample
import pl.tkosinski.accountingadmin.domain.user.dto.UserRoleDto
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
        var dataToSave = userEntitySample().build()

        when:
        var savedData = repository.save(dataToSave)

        then:
        savedData.id == dataToSave.id
        savedData.name == dataToSave.name
    }

    def "should retrieve user"() {
        given:
        var dataToSave = userEntitySample().build()
        var userId = repository.save(dataToSave).id

        when:
        var retrievedData = repository.get(userId).get()

        then:
        retrievedData.name == dataToSave.name
    }

    def "should edit name of user"() {
        given:
        var dataToSave = userEntitySample().build()
        var name = dataToSave.getName()
        var userId = repository.save(dataToSave).id

        when:
        var retrievedData = repository.editName(new UserNameRequest(new UserRoleDto(EMPLOYEE), userId, FullName.ofValue("differentFirstname", "differentLastName")))

        then:
        retrievedData.name != name
    }

    def "should delete user"() {
        given:
        var dataToSave = userEntitySample().build()
        var userId = repository.save(dataToSave).id

        when:
        repository.delete(userId)

        then:
        repository.userDb.isEmpty()
    }

    def "should return repository size"() {
        when:
        repository.save(userEntitySample().build())

        then:
        repository.size() == 1
    }

    def "should generate and return user"() {
        when:
        def generatedEntity = repository.generate()

        then:
        generatedEntity.name != null
    }

    def "should generate and save user"() {
        given:
        def generatedEntity = repository.generateAndSave()

        when:
        def retrievedData = repository.get(generatedEntity.id).get()

        then:
        retrievedData.name == generatedEntity.name
    }
}
