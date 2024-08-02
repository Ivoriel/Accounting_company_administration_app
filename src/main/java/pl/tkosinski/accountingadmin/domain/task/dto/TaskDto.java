package pl.tkosinski.accountingadmin.domain.task.dto;

import lombok.Builder;
import lombok.Value;
import pl.tkosinski.accountingadmin.common.model.Text;
import pl.tkosinski.accountingadmin.common.model.Id;

import java.time.LocalDateTime;

@Value
@Builder
public class TaskDto {

    Id id;
    Id performerId;
    LocalDateTime start;
    LocalDateTime end;
    Text title;
    Text comment;
}
