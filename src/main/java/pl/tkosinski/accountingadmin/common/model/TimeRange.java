package pl.tkosinski.accountingadmin.common.model;

import java.time.LocalDateTime;

public class TimeRange {

    private LocalDateTime from;
    private LocalDateTime to;

    private TimeRange() {}

    private TimeRange(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
    }

    public static TimeRange ofValue(LocalDateTime from, LocalDateTime to) {
        return new TimeRange(from, to);
    }

    public static TimeRange ofValue(LocalDateTime from) {
        return new TimeRange(from, null);
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }
}
