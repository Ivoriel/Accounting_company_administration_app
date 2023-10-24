package pl.tkosinski.accountingadmin.domain.address;

import pl.tkosinski.accountingadmin.common.BaseRepository;

import java.util.Optional;

interface AddressRepository extends BaseRepository<AddressDao> {

    AddressDao save(AddressDao addressDao);

    Optional<AddressDao> get(long id);

    void delete(long id);

    int size();

    AddressDao generate();

    AddressDao generateAndSave();
}
