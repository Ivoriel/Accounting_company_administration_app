package pl.tkosinski.accountingadmin.domain.task.dto;

import lombok.Builder;
import lombok.Value;
import pl.tkosinski.accountingadmin.common.model.Comment;
import pl.tkosinski.accountingadmin.common.model.Id;

import java.time.LocalDateTime;

@Value
@Builder
public class TaskDto {

    Id id;
    LocalDateTime start;
    LocalDateTime end;
    Comment comment;
}
