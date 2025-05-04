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
                .region(addressEntity.getRegion())
                .zipCode(addressEntity.getZipCode())
                .street(addressEntity.getStreet())
                .buildingNumber(addressEntity.getBuildingNumber())
                .additionalIdentifier(addressEntity.getAdditionalIdentifier())
                .build();
    }

    public static AddressEntity toDao(AddressRecord dto) {
        return AddressEntity.builder()
                .id(dto.id())
                .country(dto.country())
                .municipality(dto.municipality())
                .region(dto.region())
                .zipCode(dto.zipCode())
                .street(dto.street())
                .buildingNumber(dto.buildingNumber())
                .additionalIdentifier(dto.additionalIdentifier())
                .build();
    }
}
