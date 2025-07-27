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

    def "should map task entity to dto"() {
        def entity = taskEntitySample().build()

        when:
        def dto = TaskMapper.toDto(entity)

        then:
        dto.id == entity.id
        dto.performerId == entity.performerId
        dto.clientCompanyId == entity.clientCompanyId
        dto.start == entity.start
        dto.end == entity.end
        dto.title == entity.title
        dto.comment == entity.comment
    }
}
