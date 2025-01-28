package pl.tkosinski.accountingadmin.domain.task

import pl.tkosinski.accountingadmin.domain.sample.UsesTaskSample
import spock.lang.Specification

class TaskMapperTest extends Specification implements UsesTaskSample {

    def "should not allow creating TaskMapper object"() {
        when:
        new TaskMapper()

        then:
        thrown(IllegalStateException.class)
    }

    def "should map task dao to dto"() {
        def dao = taskDaoSample().build()

        when:
        def dto = TaskMapper.toDto(dao)

        then:
        dto.id == dao.id
        dto.performerId == dao.performerId
        dto.clientCompanyId == dao.clientCompanyId
        dto.start == dao.start
        dto.end == dao.end
        dto.title == dao.title
        dto.comment == dao.comment
    }
}
