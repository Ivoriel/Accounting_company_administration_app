package pl.tkosinski.accountingadmin.domain.address;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.address.dto.AddressDto;
import pl.tkosinski.accountingadmin.domain.address.dto.AddressRequest;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AddressFacade {

    private final AddressRepository addressRepository;

    public void save(AddressRequest request) {
        addressRepository.get(request.id())
                .ifPresentOrElse(it -> updateAddress(it, request), () -> createAddress(request));
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

    private void updateAddress(AddressDao dao, AddressRequest request) {
        addressRepository.save(dao.edit(request));
    }

    private void createAddress(AddressRequest request) {
        addressRepository.save(new AddressDao(Id.ofValue(addressRepository.size()), request.country(),
                request.municipality(), request.region(), request.zipCode(), request.street(), request.buildingNumber(),
                request.additionalIdentifier()));
    }
}
