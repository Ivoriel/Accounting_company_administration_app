package pl.tkosinski.accountingadmin.common.model;

import java.io.Serializable;

public record Text(String value) implements Serializable, Validatable {

    public static Text ofValue(String value) {
        return new Text(value);
    }

    public void validate() {
        if (value == null) {
            throw new UnsupportedOperationException();
        }
    }
}
