package pl.tkosinski.accountingadmin.common.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Id id = (Id) o;
        return value == id.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
