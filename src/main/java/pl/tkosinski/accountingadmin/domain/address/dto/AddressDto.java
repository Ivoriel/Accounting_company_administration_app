package pl.tkosinski.accountingadmin.domain.address.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;
import pl.tkosinski.accountingadmin.common.model.Id;

import static lombok.AccessLevel.PRIVATE;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = PRIVATE, force = true)
public class AddressDto {

    Id id;
    String country;
    String municipality;
    String region;
    String zipCode;
    String street;
    String buildingNumber;
    String additionalIdentifier;
}
