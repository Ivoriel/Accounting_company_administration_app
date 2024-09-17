package pl.tkosinski.accountingadmin.common.model;

public record Id(long value) {

    public static Id ofValue(long value) {
        return new Id(value);
    }
}
