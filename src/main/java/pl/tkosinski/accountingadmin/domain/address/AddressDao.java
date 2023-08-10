package pl.tkosinski.accountingadmin.domain.address;

import lombok.Builder;
import lombok.Getter;
import pl.tkosinski.accountingadmin.common.BaseDao;

@Builder
@Getter
public class AddressDao extends BaseDao {
    
    private final long id;
    private String country;
    private String municipality;
    private String region;
    private String zipCode;
    private String street;
    private String buildingNumber;
    private String additionalIdentifier;

    public AddressDao(long id, String country, String municipality, String region, String zipCode, String street,
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

    public AddressDao edit(String country, String municipality, String region, String zipCode, String street,
                     String buildingNumber, String additionalIdentifier) {
        this.country = country;
        this.municipality = municipality;
        this.region = region;
        this.zipCode = zipCode;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.additionalIdentifier = additionalIdentifier;
        return this;
    }

    public long getId() {
        return id;
    }
}
