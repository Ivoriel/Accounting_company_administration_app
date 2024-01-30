package pl.tkosinski.accountingadmin.common;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.util.Objects;

@Value
@Builder
public class FullName implements Serializable {

    String givenName;
    String lastName;
    String otherIdentifier;

    private FullName(String givenName, String lastName) {
        this.givenName = givenName;
        this.lastName = lastName;
        this.otherIdentifier = null;
    }

    private FullName(String givenName, String lastName, String otherIdentifier) {
        this.givenName = givenName;
        this.lastName = lastName;
        this.otherIdentifier = otherIdentifier;
    }

    public static FullName ofValue(String givenName, String lastName) {
        return new FullName(givenName, lastName);
    }

    public static FullName ofValue(String givenName, String lastName, String otherIdentifier) {
        return new FullName(givenName, lastName, otherIdentifier);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullName fullName = (FullName) o;
        return givenName.equals(fullName.givenName)
                && lastName.equals(fullName.lastName)
                && Objects.equals(otherIdentifier, fullName.otherIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(givenName, lastName, otherIdentifier);
    }
}
