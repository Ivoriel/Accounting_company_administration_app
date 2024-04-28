package pl.tkosinski.accountingadmin.common.model;

import lombok.Value;

import java.io.Serializable;

@Value
public class Comment implements Serializable, Validatable {

    String value;

    private Comment(String value) {
        this.value = value;
    }

    public static Comment ofValue(String value) {
        return new Comment(value);
    }

    public void validate() {
        if (value == null) {
            throw new UnsupportedOperationException();
        }
    }
}
