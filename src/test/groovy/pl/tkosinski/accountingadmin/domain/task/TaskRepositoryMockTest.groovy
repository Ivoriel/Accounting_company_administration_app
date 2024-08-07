package pl.tkosinski.accountingadmin.domain.task

import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.domain.sample.UsesTaskSample
import pl.tkosinski.accountingadmin.domain.sample.UsesUserSample
import pl.tkosinski.accountingadmin.domain.user.UserFacade
import spock.lang.Shared
import spock.lang.Specification

class TaskRepositoryMockTest extends Specification implements UsesTaskSample, UsesUserSample {

    @Shared
    UserFacade userFacade = Stub()
    TaskRepository repository = new TaskRepositoryMock(new HashMap<Id, TaskDao>(), userFacade)

    def setupSpec() {
        userFacade.getRequestedOrGenerateAndSave(_ as Id) >> userDtoSample().build()
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
        generatedDao.start == retrievedDao.start
        generatedDao.end == retrievedDao.end
        generatedDao.title == retrievedDao.title
        generatedDao.comment == retrievedDao.comment
    }
}
