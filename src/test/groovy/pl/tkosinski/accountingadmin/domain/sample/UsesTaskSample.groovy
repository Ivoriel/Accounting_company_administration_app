package pl.tkosinski.accountingadmin.domain.sample

import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.common.model.Text
import pl.tkosinski.accountingadmin.common.model.TimeRange
import pl.tkosinski.accountingadmin.domain.task.TaskEntity

import java.time.LocalDateTime

trait UsesTaskSample {

    TaskEntity.TaskEntityBuilder taskEntitySample(def args = null) {
        TaskEntity.builder()
                .id(args?.id ?: Id.generate())
                .performerId(args?.performerId ?: Id.generate())
                .period(TimeRange.ofValue(
                        LocalDateTime.now().minusMinutes(60),
                        LocalDateTime.now().minusMinutes(5)))
                .title(Text.ofValue("test title"))
                .comment(Text.ofValue( "test comment"))
    }

}