package pl.tkosinski.accountingadmin.domain.task

import spock.lang.Specification

class TaskRepositoryMockTest extends Specification {

    TaskRepository repository = new TaskRepositoryMock(new HashMap<Long, TaskDao>())

    def "should generate initial db when instance is created"() {
        when:
        repository.init()

        then:
        repository.size() > 0
    }

    def "Save"() {
    }

    def "Get"() {
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
