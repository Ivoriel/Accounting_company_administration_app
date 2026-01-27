package pl.tkosinski.accountingadmin.domain.address;

import pl.tkosinski.accountingadmin.domain.address.dto.AddressDto;
import pl.tkosinski.accountingadmin.domain.address.dto.AddressRecord;

import static pl.tkosinski.accountingadmin.common.exception.code.Utility.UTILITY_CLASS;

class AddressMapper {

    private AddressMapper() {
        throw new IllegalStateException(UTILITY_CLASS.message);
    }

    public static AddressDto toDto(AddressEntity addressEntity) {
        return AddressDto.builder()
                .id(addressEntity.getId())
                .country(addressEntity.getCountry())
                .municipality(addressEntity.getMunicipality())
                .zipCode(addressEntity.getZipCode())
                .streetAndBuildingId(addressEntity.getStreetAndBuildingId())
                .build();
    }

    public static AddressEntity toEntity(AddressRecord dto) {
        return new AddressEntity(
                dto.id(),
                dto.country(),
                dto.municipality(),
                dto.zipCode(),
                dto.streetAndBuildingId());
    }
}
