package pl.tkosinski.accountingadmin.domain.task;

import lombok.Builder;
import lombok.Getter;
import pl.tkosinski.accountingadmin.common.BaseDao;
import pl.tkosinski.accountingadmin.common.model.Text;
import pl.tkosinski.accountingadmin.common.model.Id;

import java.time.LocalDateTime;

@Getter
@Builder
class TaskDao extends BaseDao {

    private final Id id;
    private Id performerId;
    private LocalDateTime start;
    private LocalDateTime end;
    private Text title;
    private Text comment;

    public TaskDao edit(Id performerId, LocalDateTime start, LocalDateTime end, Text title, Text text) {
        this.performerId = performerId;
        this.start = start;
        this.end = end;
        this.title = title;
        this.comment = text;
        return this;
    }
}
