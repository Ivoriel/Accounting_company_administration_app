package pl.tkosinski.accountingadmin.domain.task

import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.domain.company.CompanyFacade
import pl.tkosinski.accountingadmin.domain.sample.UsesCompanySample
import pl.tkosinski.accountingadmin.domain.sample.UsesTaskSample
import pl.tkosinski.accountingadmin.domain.sample.UsesUserSample
import pl.tkosinski.accountingadmin.domain.task.dto.TaskAssignmentDto
import pl.tkosinski.accountingadmin.domain.user.UserFacade
import pl.tkosinski.accountingadmin.domain.user.dto.UserRoleDto
import spock.lang.Shared
import spock.lang.Specification

import static pl.tkosinski.accountingadmin.common.model.Role.EMPLOYEE

class TaskRepositoryMockTest extends Specification implements UsesTaskSample, UsesUserSample, UsesCompanySample {

    @Shared
    UserFacade userFacade = Stub()
    @Shared
    CompanyFacade companyFacade = Stub()
    TaskRepository repository = new TaskRepositoryMock(new HashMap<Id, TaskEntity>(), userFacade, companyFacade)

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
        var dataToSave = taskEntitySample().build()

        when:
        var savedData = repository.save(dataToSave)

        then:
        savedData.performerId == dataToSave.performerId
        savedData.clientCompanyId == dataToSave.clientCompanyId
        savedData.period == dataToSave.period
        savedData.title == dataToSave.title
        savedData.comment == dataToSave.comment
    }

    def "should retrieve task"() {
        given:
        var dataToSave = taskEntitySample().build()
        var taskId = repository.save(dataToSave).id

        when:
        var retrievedData = repository.get(taskId).get()

        then:
        retrievedData.performerId == dataToSave.performerId
        retrievedData.clientCompanyId == dataToSave.clientCompanyId
        retrievedData.period == dataToSave.period
        retrievedData.title == dataToSave.title
        retrievedData.comment == dataToSave.comment
    }

    def "should delete task"() {
        given:
        var dataToSave = taskEntitySample().build()
        var taskId = repository.save(dataToSave).id

        when:
        repository.delete(taskId)

        then:
        repository.taskDb.isEmpty()
    }

    def "should return repository size"() {
        when:
        repository.save(taskEntitySample().build())

        then:
        repository.size() == 1
    }

    def "should generate and return task"() {
        when:
        def generatedData = repository.generate()

        then:
        generatedData.performerId != null
        generatedData.clientCompanyId != null
        generatedData.period != null
        generatedData.title != null
        generatedData.comment != null
    }

    def "should generate and return saved task"() {
        given:
        def generatedData = repository.generateAndSave()

        when:
        def retrievedData = repository.get(generatedData.id).get()

        then:
        generatedData.performerId == retrievedData.performerId
        generatedData.clientCompanyId == retrievedData.clientCompanyId
        generatedData.period == retrievedData.period
        generatedData.title == retrievedData.title
        generatedData.comment == retrievedData.comment
    }

    def "should assign task"() {
        given:
        def generatedEntity = repository.generateAndSave()
        def performerId = Id.generate()

        when:
        repository.assignTask(new TaskAssignmentDto(new UserRoleDto(EMPLOYEE), generatedEntity.id, performerId))
        def assignedTaskEntity = repository.get(generatedEntity.id).get()

                then:
        generatedEntity.performerId == assignedTaskEntity.performerId
    }

    def "should begin task"() {
        given:
        def generatedEntity = repository.generateAndSave()

        when:
        var start = repository.beginTask(generatedEntity.id)

        then:
        repository.get(generatedEntity.id).get().period.from == start
    }

    def "should finish task"() {
        given:
        def generatedEntity = repository.generateAndSave()

        when:
        var finish = repository.finishTask(generatedEntity.id)

        then:
        repository.get(generatedEntity.id).get().period.to == finish
    }
}
