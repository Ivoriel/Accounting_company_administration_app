package pl.tkosinski.accountingadmin.domain.address;

import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.domain.address.dto.AddressDto;

import java.util.NoSuchElementException;

@Component
public class AddressFacade {

    AddressRepository addressRepository;

    public void save(AddressDto addressDto) {
        addressRepository.get(addressDto.getId())
                .ifPresentOrElse(it -> updateAddress(it, addressDto), () -> createAddress(addressDto));
    }

    public AddressDto get(long id) {
        return AddressMapper.toDto(addressRepository.get(id).orElseThrow(NoSuchElementException::new));
    }

    public void delete(long id) {
        addressRepository.delete(id);
    }

    public AddressDto generate() {;
        return addressRepository.generate();
    }

    private void updateAddress(AddressDao dao, AddressDto dto) {
        addressRepository.save(dao.edit(dto.getCountry(), dto.getMunicipality(), dto.getRegion(), dto.getZipCode(),
                dto.getStreet(), dto.getBuildingNumber(), dto.getAdditionalIdentifier()));
    }

    private void createAddress(AddressDto dto) {
        addressRepository.save(new AddressDao(addressRepository.size(), dto.getCountry(), dto.getMunicipality(),
                dto.getRegion(), dto.getZipCode(), dto.getStreet(), dto.getBuildingNumber(),
                dto.getAdditionalIdentifier()));
    }
}
