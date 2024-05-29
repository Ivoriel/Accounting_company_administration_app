package pl.tkosinski.accountingadmin.domain.sample

import pl.tkosinski.accountingadmin.common.model.Comment
import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.domain.task.TaskDao

import java.time.LocalDateTime

trait UsesTaskSample {

    TaskDao.TaskDaoBuilder taskDaoSample(def args = null) {
        TaskDao.builder()
                .id(Id.ofValue(args?.id ?: 16))
                .performerId(Id.ofValue(808))
                .start(LocalDateTime.now().minusMinutes(60))
                .end(LocalDateTime.now().minusMinutes(5))
                .comment(Comment.ofValue( "test comment"))
    }

}