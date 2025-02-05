package pl.tkosinski.accountingadmin.domain.task;

import lombok.Builder;
import lombok.Getter;
import pl.tkosinski.accountingadmin.common.BaseDao;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.common.model.Text;
import pl.tkosinski.accountingadmin.domain.task.dto.TaskRequest;

import java.time.LocalDateTime;

@Getter
@Builder
class TaskDao extends BaseDao {

    private final Id id;
    private Id performerId;
    private Id clientCompanyId;
    private LocalDateTime start;
    private LocalDateTime end;
    private Text title;
    private Text comment;

    protected TaskDao edit(TaskRequest request) {
        this.performerId = request.performerId();
        this.clientCompanyId = request.clientCompanyId();
        this.start = request.start();
        this.end = request.end();
        this.title = request.title();
        this.comment = request.comment();
        return this;
    }

    protected void assignTask(Id performerId) {
        this.performerId = performerId;
    }

    protected LocalDateTime beginTask() {
        this.start = LocalDateTime.now();

        return start;
    }

    protected LocalDateTime finishTask() {
        this.start = LocalDateTime.now();

        return end;
    }
}
