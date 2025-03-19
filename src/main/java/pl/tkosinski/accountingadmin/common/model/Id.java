package pl.tkosinski.accountingadmin.common.model;

import java.util.UUID;

public record Id(UUID value) {

    public static Id ofValue(UUID value) {
        return new Id(value);
    }

    public static Id generate() {
        return new Id(UUID.randomUUID());
    }
}
