package pl.tkosinski.accountingadmin.domain.task;

import lombok.Builder;
import lombok.Getter;
import pl.tkosinski.accountingadmin.common.BaseDao;

import java.time.LocalDateTime;

@Getter
@Builder
public class TaskDao extends BaseDao {

    private final long id;
    private LocalDateTime start;
    private LocalDateTime end;
    private String comment;

    public TaskDao edit(LocalDateTime start, LocalDateTime end, String comment) {
        this.start = start;
        this.end = end;
        this.comment = comment;
        return this;
    }
}
