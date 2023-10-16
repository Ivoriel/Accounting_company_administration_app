package pl.tkosinski.accountingadmin.domain.task;

import lombok.Builder;
import lombok.Getter;
import pl.tkosinski.accountingadmin.common.BaseDao;

@Getter
@Builder
public class TaskDao extends BaseDao {

    private final long id;
}
