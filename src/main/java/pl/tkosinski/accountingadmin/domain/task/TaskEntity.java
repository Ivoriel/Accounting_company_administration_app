package pl.tkosinski.accountingadmin.domain.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import pl.tkosinski.accountingadmin.common.BaseDao;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.common.model.Text;
import pl.tkosinski.accountingadmin.common.model.TimeRange;
import pl.tkosinski.accountingadmin.domain.task.dto.TaskRequest;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
class TaskEntity implements BaseDao {

    private final Id id;
    private Id performerId;
    private Id clientCompanyId;
    private TimeRange period;
    private Text title;
    private Text comment;

    public TaskEntity(Id id, TaskRequest request) {
        this.id = id;
        this.performerId = request.performerId();
        this.clientCompanyId = request.clientCompanyId();
        this.period = request.period();
        this.title = request.title();
        this.comment = request.comment();
    }

    protected TaskEntity edit(TaskRequest request) {
        this.performerId = request.performerId();
        this.clientCompanyId = request.clientCompanyId();
        this.period = request.period();
        this.title = request.title();
        this.comment = request.comment();
        return this;
    }

    protected void assignTask(Id performerId) {
        this.performerId = performerId;
    }

    protected void beginTask() {
        this.period.setFrom(LocalDateTime.now());
    }

    protected void finishTask() {
        this.period.setTo(LocalDateTime.now());
    }
}
