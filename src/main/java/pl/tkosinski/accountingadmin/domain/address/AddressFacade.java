package pl.tkosinski.accountingadmin.domain.address;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.address.dto.AddressDto;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AddressFacade {

    private final AddressRepository addressRepository;

    public void save(AddressDto addressDto) {
        addressRepository.get(addressDto.getId())
                .ifPresentOrElse(it -> updateAddress(it, addressDto), () -> createAddress(addressDto));
    }

    public AddressDto get(Id id) {
        return AddressMapper.toDto(addressRepository.get(id).orElseThrow(NoSuchElementException::new));
    }

    public AddressDto getRequestedOrGenerateAndSave(Id id) {
        return AddressMapper.toDto(addressRepository.get(id)
                .orElse(addressRepository.generateAndSave()));
    }

    public void delete(Id id) {
        addressRepository.delete(id);
    }

    public AddressDto generate() {
        return AddressMapper.toDto(addressRepository.generate());
    }

    public AddressDto generateAndSave() {
        return AddressMapper.toDto(addressRepository.generateAndSave());
    }

    private void updateAddress(AddressDao dao, AddressDto dto) {
        addressRepository.save(dao.edit(dto.getCountry(), dto.getMunicipality(), dto.getRegion(), dto.getZipCode(),
                dto.getStreet(), dto.getBuildingNumber(), dto.getAdditionalIdentifier()));
    }

    private void createAddress(AddressDto dto) {
        addressRepository.save(new AddressDao(Id.ofValue(addressRepository.size()), dto.getCountry(),
                dto.getMunicipality(), dto.getRegion(), dto.getZipCode(), dto.getStreet(), dto.getBuildingNumber(),
                dto.getAdditionalIdentifier()));
    }
}
