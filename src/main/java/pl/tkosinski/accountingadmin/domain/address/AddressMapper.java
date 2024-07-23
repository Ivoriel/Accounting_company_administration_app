package pl.tkosinski.accountingadmin.domain.address;

import pl.tkosinski.accountingadmin.domain.address.dto.AddressDto;

class AddressMapper {

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
