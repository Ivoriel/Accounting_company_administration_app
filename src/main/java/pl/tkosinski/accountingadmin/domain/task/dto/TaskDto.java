package pl.tkosinski.accountingadmin.domain.task.dto;

import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.common.model.Text;

import java.time.LocalDateTime;

public record TaskDto(Id id,
                      Id performerId,
                      Id clientCompanyId, LocalDateTime start,
                      LocalDateTime end, Text title,
                      Text comment) {

}
