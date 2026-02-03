package pl.tkosinski.accountingadmin.domain.address;

import lombok.Builder;
import lombok.Getter;
import pl.tkosinski.accountingadmin.common.BaseEntity;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.address.dto.AddressRecord;

@Builder
@Getter
class AddressEntity implements BaseEntity {

    private final Id id;
    private String country;
    private String municipality;
    private String zipCode;
    private String streetAndBuildingId;

    AddressEntity(Id id, String country, String municipality, String zipCode, String streetAndBuildingId) {
        this.id = id;
        this.country = country;
        this.municipality = municipality;
        this.zipCode = zipCode;
        this.streetAndBuildingId = streetAndBuildingId;
    }

    public AddressEntity(String country, String municipality, String zipCode, String streetAndBuildingId) {
        this.id = Id.generate();
        this.country = country;
        this.municipality = municipality;
        this.zipCode = zipCode;
        this.streetAndBuildingId = streetAndBuildingId;
    }

    public AddressEntity(AddressRecord request) {
        this.id = Id.generate();
        this.country = request.country();
        this.municipality = request.municipality();
        this.zipCode = request.zipCode();
        this.streetAndBuildingId = request.streetAndBuildingId();
    }

    public AddressEntity edit(AddressRecord request) {
        this.country = request.country();
        this.municipality = request.municipality();
        this.zipCode = request.zipCode();
        this.streetAndBuildingId = request.streetAndBuildingId();
        return this;
    }
}
