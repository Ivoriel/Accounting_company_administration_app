package pl.tkosinski.accountingadmin.domain.address;

import lombok.Builder;
import lombok.Getter;
import pl.tkosinski.accountingadmin.common.BaseDao;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.address.dto.AddressRequest;

@Builder
@Getter
class AddressDao implements BaseDao {
    
    private final Id id;
    private String country;
    private String municipality;
    private String region;
    private String zipCode;
    private String street;
    private String buildingNumber;
    private String additionalIdentifier;

    public AddressDao(Id id, String country, String municipality, String region, String zipCode, String street,
               String buildingNumber, String additionalIdentifier) {
        this.id = id;
        this.country = country;
        this.municipality = municipality;
        this.region = region;
        this.zipCode = zipCode;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.additionalIdentifier = additionalIdentifier;
    }

    public AddressDao(Id id, AddressRequest request) {
        this.id = id;
        this.country = request.country();
        this.municipality = request.municipality();
        this.region = request.region();
        this.zipCode = request.zipCode();
        this.street = request.street();
        this.buildingNumber = request.buildingNumber();
        this.additionalIdentifier = request.additionalIdentifier();
    }

    public AddressDao edit(AddressRequest request) {
        this.country = request.country();
        this.municipality = request.municipality();
        this.region = request.region();
        this.zipCode = request.zipCode();
        this.street = request.street();
        this.buildingNumber = request.buildingNumber();
        this.additionalIdentifier = request.additionalIdentifier();
        return this;
    }
}
