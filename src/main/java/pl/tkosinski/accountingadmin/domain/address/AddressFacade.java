package pl.tkosinski.accountingadmin.domain.address;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.address.dto.AddressDto;
import pl.tkosinski.accountingadmin.domain.address.dto.AddressRecord;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AddressFacade {

    private final AddressRepository addressRepository;

    public void save(AddressRecord request) {
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
        return new AddressGenerator().generate();
    }

    public AddressDto generateAndSave() {
        return AddressMapper.toDto(addressRepository.save(AddressMapper.toEntity(generate())));
    }

    private void updateAddress(AddressEntity dao, AddressRecord request) {
        addressRepository.save(dao.edit(request));
    }

    private void createAddress(AddressRecord request) {
        addressRepository.save(new AddressEntity(request));
    }
}
