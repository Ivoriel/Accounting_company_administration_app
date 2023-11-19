package pl.tkosinski.accountingadmin.domain.task;

import lombok.Builder;
import lombok.Getter;
import pl.tkosinski.accountingadmin.common.BaseDao;

import java.time.LocalDateTime;

@Getter
@Builder
public class TaskDao extends BaseDao {

    private final long id;
    private final LocalDateTime start;
    private final LocalDateTime end;
    private final String comment;

    public TaskDao edit() {
        return this;
    }
}
