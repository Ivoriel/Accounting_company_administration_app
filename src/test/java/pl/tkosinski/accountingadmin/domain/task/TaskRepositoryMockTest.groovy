package pl.tkosinski.accountingadmin.domain.task

import pl.tkosinski.accountingadmin.domain.client.ClientDao
import spock.lang.Specification

import java.time.LocalDateTime

class TaskRepositoryMockTest extends Specification {

    TaskRepository repository = new TaskRepositoryMock(new HashMap<Long, TaskDao>())

    def "should generate initial db when instance is created"() {
        when:
        repository.init()

        then:
        repository.size() > 0
    }

    def "should create and save task"() {
        given:
        var daoToSave = TaskDao.builder()
                .start(LocalDateTime.now().minusMinutes(60))
                .end(LocalDateTime.now().minusMinutes(5))
                .comment("test comment")
                .build()

        when:
        var savedDao = repository.save(daoToSave)

        then:
        savedDao.start == daoToSave.start
        savedDao.end == daoToSave.end
        savedDao.comment == daoToSave.comment
    }

    def "should retrieve task"() {
        given:
        var daoToSave = TaskDao.builder()
                .start(LocalDateTime.now().minusMinutes(60))
                .end(LocalDateTime.now().minusMinutes(5))
                .comment("test comment")
                .build()
        var taskId = repository.save(daoToSave).id

        when:
        var retrievedDao = repository.get(taskId).get()

        then:
        retrievedDao.start == daoToSave.start
        retrievedDao.end == daoToSave.end
        retrievedDao.comment == daoToSave.comment
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
