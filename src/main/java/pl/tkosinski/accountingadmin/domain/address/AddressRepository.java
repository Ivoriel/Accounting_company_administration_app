package pl.tkosinski.accountingadmin.domain.address;

import pl.tkosinski.accountingadmin.common.BaseRepository;
import pl.tkosinski.accountingadmin.common.model.Id;

import java.util.Optional;

interface AddressRepository extends BaseRepository<AddressDao> {

    AddressDao save(AddressDao addressDao);

    Optional<AddressDao> get(Id id);

    Optional<AddressDao> getLast();

    void delete(Id id);

    int size();

    AddressDao generate();

    AddressDao generateAndSave();
}
