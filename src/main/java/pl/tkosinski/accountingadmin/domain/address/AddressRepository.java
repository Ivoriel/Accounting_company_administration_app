package pl.tkosinski.accountingadmin.domain.address;

import pl.tkosinski.accountingadmin.Common.BaseRepository;
import pl.tkosinski.accountingadmin.domain.address.dto.AddressDto;

import java.util.Optional;

interface AddressRepository extends BaseRepository {

    AddressDao save(AddressDao addressDao);

    Optional<AddressDao> get(long id);

    void delete(long id);

    int size();

    AddressDao generate();

}
