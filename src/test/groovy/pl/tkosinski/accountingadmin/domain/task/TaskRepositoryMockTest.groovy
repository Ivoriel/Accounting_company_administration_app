package pl.tkosinski.accountingadmin.domain.task

import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.domain.company.CompanyFacade
import pl.tkosinski.accountingadmin.domain.sample.UsesCompanySample
import pl.tkosinski.accountingadmin.domain.sample.UsesTaskSample
import pl.tkosinski.accountingadmin.domain.sample.UsesUserSample
import pl.tkosinski.accountingadmin.domain.task.dto.TaskAssignmentDto
import pl.tkosinski.accountingadmin.domain.user.UserFacade
import spock.lang.Shared
import spock.lang.Specification

class TaskRepositoryMockTest extends Specification implements UsesTaskSample, UsesUserSample, UsesCompanySample {

    @Shared
    UserFacade userFacade = Stub()
    @Shared
    CompanyFacade companyFacade = Stub()
    TaskRepository repository = new TaskRepositoryMock(new HashMap<Id, TaskDao>(), userFacade, companyFacade)

    def setupSpec() {
        userFacade.getRequestedOrGenerateAndSave(_ as Id) >> userDtoSample()
        companyFacade.getRequestedOrGenerateAndSave(_ as Id) >> companyDtoSample()
    }

    def "should generate initial db when instance is created"() {
        when:
        repository.init()

        then:
        repository.size() > 0
    }

    def "should create and save task"() {
        given:
        var daoToSave = taskDaoSample().build()

        when:
        var savedDao = repository.save(daoToSave)

        then:
        savedDao.performerId == daoToSave.performerId
        savedDao.clientCompanyId == daoToSave.clientCompanyId
        savedDao.start == daoToSave.start
        savedDao.end == daoToSave.end
        savedDao.title == daoToSave.title
        savedDao.comment == daoToSave.comment
    }

    def "should retrieve task"() {
        given:
        var daoToSave = taskDaoSample().build()
        var taskId = repository.save(daoToSave).id

        when:
        var retrievedDao = repository.get(taskId).get()

        then:
        retrievedDao.performerId == daoToSave.performerId
        retrievedDao.clientCompanyId == daoToSave.clientCompanyId
        retrievedDao.start == daoToSave.start
        retrievedDao.end == daoToSave.end
        retrievedDao.title == retrievedDao.title
        retrievedDao.comment == daoToSave.comment
    }

    def "should delete task"() {
        given:
        var daoToSave = taskDaoSample().build()
        var taskId = repository.save(daoToSave).id

        when:
        repository.delete(taskId)

        then:
        repository.taskDb.isEmpty()
    }

    def "should return repository size"() {
        when:
        repository.save(taskDaoSample().build())

        then:
        repository.size() == 1
    }

    def "should generate and return task"() {
        when:
        def generatedDao = repository.generate()

        then:
        generatedDao.performerId != null
        generatedDao.clientCompanyId != null
        generatedDao.start != null
        generatedDao.end != null
        generatedDao.title != null
        generatedDao.comment != null
    }

    def "should generate and return saved task"() {
        given:
        def generatedDao = repository.generateAndSave()

        when:
        def retrievedDao = repository.get(generatedDao.id).get()

        then:
        generatedDao.performerId == retrievedDao.performerId
        generatedDao.clientCompanyId == retrievedDao.clientCompanyId
        generatedDao.start == retrievedDao.start
        generatedDao.end == retrievedDao.end
        generatedDao.title == retrievedDao.title
        generatedDao.comment == retrievedDao.comment
    }

    def "should assign task"() {
        given:
        def generatedDao = repository.generateAndSave()
        def performerId = Id.ofValue(Long.MAX_VALUE)

        when:
        repository.assignTask(new TaskAssignmentDto(generatedDao.id, performerId))
        def assignedTaskDao = repository.get(generatedDao.id).get()

                then:
        generatedDao.performerId == assignedTaskDao.performerId
    }

    def "should begin task"() {
        given:
        def generatedDao = repository.generateAndSave()

        when:
        var start = repository.beginTask(generatedDao.id)

        then:
        repository.get(generatedDao.id).get().start == start
    }

    def "should finish task"() {
        given:
        def generatedDao = repository.generateAndSave()

        when:
        var finish = repository.finishTask(generatedDao.id)

        then:
        repository.get(generatedDao.id).get().end == finish
    }
}
