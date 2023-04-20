package pl.tkosinski.accountingadmin.domain.address;

import lombok.var;
import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.domain.address.dto.AddressDto;

import java.util.Optional;

@Component
public class AddressServiceImpl implements AddressService{

    AddressRepository addressRepository;

    @Override
    public AddressDto save(AddressDto addressDto) {
        Optional<AddressDao> addressDaoOptional = addressRepository.get(addressDto.getId());
        AddressDao addressDao;
        if (Optional.ofNullable(addressDaoOptional).isPresent()) {
            addressDao = addressDaoOptional.get();
            addressDao.edit(addressDto.getCountry(),
                    addressDto.getMunicipality(), addressDto.getRegion(), addressDto.getZipCode(), addressDto.getStreet(),
                    addressDto.getBuildingNumber(), addressDto.getAdditionalIdentifier());
        } else {
            addressDao = new AddressDao(addressRepository.size(), addressDto.getCountry(), addressDto.getMunicipality(),
                    addressDto.getRegion(), addressDto.getZipCode(), addressDto.getStreet(),
                    addressDto.getBuildingNumber(), addressDto.getAdditionalIdentifier());
        }
        return toDto(addressRepository.save(addressDao));
    }

    @Override
    public AddressDto get(long id) {
        AddressDto addressDto = new AddressDto();
        Optional<AddressDao> addressDaoOptional = addressRepository.get(id);
        if (Optional.ofNullable(addressDaoOptional).isPresent()) {
            addressDto = toDto(addressDaoOptional.get());
        }
        return addressDto;
    }

    @Override
    public void delete(long id) {
        addressRepository.delete(id);
    }

    @Override
    public AddressDto generate() {;
        return addressRepository.generate();
    }

    private AddressDto toDto(AddressDao addressDao) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(addressDao.getId());
        addressDto.setCountry(addressDao.getCountry());
        addressDto.setMunicipality(addressDao.getMunicipality());
        addressDto.setRegion(addressDao.getRegion());
        addressDto.setZipCode(addressDao.getZipCode());
        addressDto.setStreet(addressDao.getStreet());
        addressDto.setBuildingNumber(addressDao.getBuildingNumber());
        addressDto.setAdditionalIdentifier(addressDao.getAdditionalIdentifier());
        return addressDto;
    }
}
