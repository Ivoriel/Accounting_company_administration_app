package pl.tkosinski.accountingadmin.common.model;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.util.Objects;

@Value
@Builder
public class InstitutionName implements Serializable {

    String name;
    String otherIdentifier;

    private InstitutionName(String name) {
        this.name = name;
        this.otherIdentifier = null;
    }

    private InstitutionName(String name, String otherIdentifier) {
        this.name = name;
        this.otherIdentifier = otherIdentifier;
    }

    public static InstitutionName ofValue(String givenName) {
        return new InstitutionName(givenName);
    }

    public static InstitutionName ofValue(String givenName, String otherIdentifier) {
        return new InstitutionName(givenName, otherIdentifier);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstitutionName fullName = (InstitutionName) o;
        return name.equals(fullName.name)
                && Objects.equals(otherIdentifier, fullName.otherIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, otherIdentifier);
    }
}
