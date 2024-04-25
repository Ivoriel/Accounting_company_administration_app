package pl.tkosinski.accountingadmin.domain.task

import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.domain.sample.UsesTaskSample
import spock.lang.Specification

import java.time.LocalDateTime

class TaskRepositoryMockTest extends Specification implements UsesTaskSample {

    TaskRepository repository = new TaskRepositoryMock(new HashMap<Id, TaskDao>())

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
        savedDao.start == daoToSave.start
        savedDao.end == daoToSave.end
        savedDao.comment == daoToSave.comment
    }

    def "should retrieve task"() {
        given:
        var daoToSave = taskDaoSample().build()
        var taskId = repository.save(daoToSave).id

        when:
        var retrievedDao = repository.get(taskId).get()

        then:
        retrievedDao.start == daoToSave.start
        retrievedDao.end == daoToSave.end
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
        generatedDao.start != null
        generatedDao.end != null
        generatedDao.comment != null
    }

    def "should generate and return saved task"() {
        given:
        def generatedDao = repository.generate()

        when:
        def retrievedDao = repository.get(generatedDao.id).get()

        then:
        generatedDao.start == retrievedDao.start
        generatedDao.end == retrievedDao.end
        generatedDao.comment == retrievedDao.comment
    }
}
