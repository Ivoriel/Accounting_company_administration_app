package pl.tkosinski.accountingadmin.domain.address;

import pl.tkosinski.accountingadmin.Common.BaseRepository;

import java.util.Optional;

public interface AddressRepository extends BaseRepository {

    AddressDao save(AddressDao addressDao);

    Optional<AddressDao> get(long id);

    void delete(long id);

    int size();

    AddressDto generate();

}
