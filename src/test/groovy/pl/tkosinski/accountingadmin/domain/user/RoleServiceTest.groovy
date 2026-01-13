package pl.tkosinski.accountingadmin.domain.user

import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.domain.sample.UsesUserSample
import spock.lang.Specification

import static pl.tkosinski.accountingadmin.common.model.Role.CLIENT
import static pl.tkosinski.accountingadmin.common.model.Role.CLIENT_ADMIN
import static pl.tkosinski.accountingadmin.common.model.Role.EMPLOYEE

class RoleServiceTest extends Specification implements UsesUserSample {

    UserRepository repository = new UserRepositoryMock(new HashMap<Id, UserEntity>())

    RoleService service = new RoleService(repository)

    def "should switch role to employee"() {
        given:
        var savedData = repository.save(userEntitySample(role: CLIENT).build())

        when:
        service.switchRoleToEmployee(savedData.getId())

        then:
        var test = repository.get(savedData.getId()).get()
        test.role == EMPLOYEE
    }

    def "should switch role to client"() {
        given:
        var savedData = repository.save(userEntitySample(role: EMPLOYEE).build())

        when:
        service.switchRoleToClient(savedData.getId())

        then:
        var test = repository.get(savedData.getId()).get()
        test.role == CLIENT
    }

    def "should switch role to client admin"() {
        given:
        var savedEntity = repository.save(userEntitySample(role: EMPLOYEE).build())

        when:
        service.switchRoleToClientAdmin(savedEntity.getId())

        then:
        var test = repository.get(savedEntity.getId()).get()
        test.role == CLIENT_ADMIN
    }
}
