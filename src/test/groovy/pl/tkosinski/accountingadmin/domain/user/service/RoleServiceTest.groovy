package pl.tkosinski.accountingadmin.domain.user.service

import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.domain.sample.UsesUserSample
import pl.tkosinski.accountingadmin.domain.user.UserDao
import pl.tkosinski.accountingadmin.domain.user.UserRepository
import pl.tkosinski.accountingadmin.domain.user.UserRepositoryMock
import spock.lang.Specification

import static pl.tkosinski.accountingadmin.common.model.Role.CLIENT
import static pl.tkosinski.accountingadmin.common.model.Role.EMPLOYEE

class RoleServiceTest extends Specification implements UsesUserSample {

    UserRepository repository = new UserRepositoryMock(new HashMap<Id, UserDao>())

    RoleService service = new RoleService(repository)

    def "should switch role to employee"() {
        given:
        var savedDao = repository.save(userDaoSample(role: CLIENT).build())

        when:
        service.switchRoleToEmployee(savedDao.getId())

        then:
        var test = repository.get(savedDao.getId()).get()
        test.role == EMPLOYEE
    }

    def "should switch role to client"() {
        given:
        var savedDao = repository.save(userDaoSample(role: EMPLOYEE).build())

        when:
        service.switchRoleToClient(savedDao.getId())

        then:
        var test = repository.get(savedDao.getId()).get()
        test.role == CLIENT
    }
}
