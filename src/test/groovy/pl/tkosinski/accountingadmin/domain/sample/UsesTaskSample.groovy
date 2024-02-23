package pl.tkosinski.accountingadmin.domain.sample

import pl.tkosinski.accountingadmin.domain.task.TaskDao

import java.time.LocalDateTime

trait UsesTaskSample {

    TaskDao.TaskDaoBuilder taskDaoSample() {
        TaskDao.builder()
                .start(LocalDateTime.now().minusMinutes(60))
                .end(LocalDateTime.now().minusMinutes(5))
                .comment("test comment")
    }

}