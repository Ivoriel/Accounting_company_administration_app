package pl.tkosinski.accountingadmin.domain.address.dto;

import pl.tkosinski.accountingadmin.common.model.Id;

public record AddressDto(Id id, String country, String municipality, String region, String zipCode, String street,
                         String buildingNumber, String additionalIdentifier) {}
