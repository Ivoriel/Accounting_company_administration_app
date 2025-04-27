package pl.tkosinski.accountingadmin.domain.address;

import pl.tkosinski.accountingadmin.domain.address.dto.AddressDto;
import pl.tkosinski.accountingadmin.domain.address.dto.AddressRecord;

import static pl.tkosinski.accountingadmin.common.exception.code.Utility.UTILITY_CLASS;

class AddressMapper {

    private AddressMapper() {
        throw new IllegalStateException(UTILITY_CLASS.message);
    }

    public static AddressDto toDto(AddressDao addressDao) {
        return AddressDto.builder()
                .id(addressDao.getId())
                .country(addressDao.getCountry())
                .municipality(addressDao.getMunicipality())
                .region(addressDao.getRegion())
                .zipCode(addressDao.getZipCode())
                .street(addressDao.getStreet())
                .buildingNumber(addressDao.getBuildingNumber())
                .additionalIdentifier(addressDao.getAdditionalIdentifier())
                .build();
    }

    public static AddressDao toDao(AddressRecord dto) {
        return AddressDao.builder()
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
