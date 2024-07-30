package pl.tkosinski.accountingadmin.common.model;

import lombok.Value;

import java.io.Serializable;

@Value
public class Text implements Serializable, Validatable {

    String value;

    private Text(String value) {
        this.value = value;
    }

    public static Text ofValue(String value) {
        return new Text(value);
    }

    public void validate() {
        if (value == null) {
            throw new UnsupportedOperationException();
        }
    }
}
