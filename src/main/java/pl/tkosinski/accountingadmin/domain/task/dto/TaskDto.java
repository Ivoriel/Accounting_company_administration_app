package pl.tkosinski.accountingadmin.domain.task.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class TaskDto {

    long id;
    LocalDateTime start;
    LocalDateTime end;
    String comment;
}
