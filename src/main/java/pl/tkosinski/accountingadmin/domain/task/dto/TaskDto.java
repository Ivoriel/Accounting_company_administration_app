package pl.tkosinski.accountingadmin.domain.task.dto;

import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.common.model.Text;
import pl.tkosinski.accountingadmin.common.model.TimeRange;

public record TaskDto(
        Id id,
        Id performerId,
        Id clientCompanyId,
        TimeRange period,
        Text title,
        Text comment) {

}
