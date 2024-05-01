package pl.tkosinski.accountingadmin.domain.task;

import lombok.Builder;
import lombok.Getter;
import pl.tkosinski.accountingadmin.common.BaseDao;
import pl.tkosinski.accountingadmin.common.model.Comment;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.user.UserDao;

import java.time.LocalDateTime;

@Getter
@Builder
public class TaskDao extends BaseDao {

    private final Id id;
    private LocalDateTime start;
    private LocalDateTime end;
    private Comment comment;
    private UserDao performer;

    public TaskDao edit(LocalDateTime start, LocalDateTime end, Comment comment) {
        this.start = start;
        this.end = end;
        this.comment = comment;
        return this;
    }
}
