package pl.tkosinski.accountingadmin.domain.task

import pl.tkosinski.accountingadmin.domain.sample.UsesTaskSample
import spock.lang.Specification

class TaskMapperTest extends Specification implements UsesTaskSample {

    TaskMapper mapper = new TaskMapper()

    def "should map task dao to dto"() {
        def dao = taskDaoSample().build()

        when:
        def dto = mapper.toDto(dao)

        then:
        dto.id == dao.id
        dto.start == dao.start
        dto.end == dao.end
        dto.title == dao.title
        dto.comment == dao.comment
    }
}
