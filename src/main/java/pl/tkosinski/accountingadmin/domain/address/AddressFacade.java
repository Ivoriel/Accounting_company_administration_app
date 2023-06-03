package pl.tkosinski.accountingadmin.domain.address;

import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.domain.address.dto.AddressDto;

import java.util.Optional;

@Component
public class AddressFacade {

    AddressRepository addressRepository;

    public void save(AddressDto addressDto) {
        addressRepository.get(addressDto.getId())
                .ifPresentOrElse(it -> updateAddress(it, addressDto), () -> createAddress(addressDto));
    }

    public AddressDto get(long id) {
        AddressDto addressDto = new AddressDto();
        Optional<AddressDao> addressDaoOptional = addressRepository.get(id);
        if (Optional.ofNullable(addressDaoOptional).isPresent()) {
            addressDto = AddressMapper.toDto(addressDaoOptional.get());
        }
        return addressDto;
    }

    public void delete(long id) {
        addressRepository.delete(id);
    }

    public AddressDto generate() {;
        return addressRepository.generate();
    }

    private void updateAddress(AddressDao dao, AddressDto dto) {
        dao.edit(dto.getCountry(), dto.getMunicipality(), dto.getRegion(), dto.getZipCode(), dto.getStreet(),
                dto.getBuildingNumber(), dto.getAdditionalIdentifier());
    }

    private void createAddress(AddressDto dto) {
        addressRepository.save(new AddressDao(addressRepository.size(), dto.getCountry(), dto.getMunicipality(),
                dto.getRegion(), dto.getZipCode(), dto.getStreet(), dto.getBuildingNumber(),
                dto.getAdditionalIdentifier()));
    }
}
