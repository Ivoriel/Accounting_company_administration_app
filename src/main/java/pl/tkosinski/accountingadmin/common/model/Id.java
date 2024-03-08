package pl.tkosinski.accountingadmin.common.model;

public class Id {
    
    private final long value;

    private Id(long value) {
        this.value = value;
    }

    public static Id ofValue(long value) {
        return new Id(value);
    }

    public long getValue() {
        return value;
    }
}
