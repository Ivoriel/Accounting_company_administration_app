package pl.tkosinski.accountingadmin.domain.task

import spock.lang.Specification

import java.time.LocalDateTime

class TaskMapperTest extends Specification {

    TaskMapper mapper = new TaskMapper()

    def "should map task dao to dto"() {
        def dao = TaskDao.builder()
                .start(LocalDateTime.now().minusMinutes(60))
                .end(LocalDateTime.now().minusMinutes(5))
                .comment("test comment")
                .build()

        when:
        def dto = mapper.toDto(dao)

        then:
        dto.id == dao.id
        dto.start == dao.start
        dto.end == dao.end
        dto.comment == dao.comment
    }
}
