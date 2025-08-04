package pl.tkosinski.accountingadmin.domain.address.dto;

import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.user.dto.UserRoleDto;

public record AddressRequest (
        UserRoleDto userId,
        Id id,
        String country,
        String municipality,
        String region,
        String zipCode,
        String street,
        String buildingNumber,
        String additionalIdentifier) implements AddressRecord{}