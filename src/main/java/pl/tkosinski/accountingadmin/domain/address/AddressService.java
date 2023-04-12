package pl.tkosinski.accountingadmin.domain.address;

import pl.kosinski.acaa_dto.AddressDto;
import pl.tkosinski.accountingadmin.domain.address.dto.AddressDto;

public interface AddressService {

    AddressDto save(AddressDto addressDto);

    AddressDto get(long id);

    void delete(long id);

    AddressDto generate();

}
