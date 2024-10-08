package pl.tkosinski.accountingadmin.domain.address;

import pl.tkosinski.accountingadmin.domain.address.dto.AddressDto;

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
}
