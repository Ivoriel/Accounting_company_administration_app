package pl.tkosinski.accountingadmin.domain.address.dto;

import lombok.Builder;
import pl.tkosinski.accountingadmin.common.model.Id;

@Builder
public record AddressDto(
        Id id,
        String country,
        String municipality,
        String zipCode,
        String streetAndBuildingId)
        implements AddressRecord {}
