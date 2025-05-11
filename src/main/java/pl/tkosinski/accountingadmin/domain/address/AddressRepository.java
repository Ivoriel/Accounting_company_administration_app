package pl.tkosinski.accountingadmin.domain.address;

import pl.tkosinski.accountingadmin.common.BaseRepository;
import pl.tkosinski.accountingadmin.common.model.Id;

import java.util.Optional;

interface AddressRepository extends BaseRepository<AddressEntity> {

    AddressEntity save(AddressEntity addressEntity);

    Optional<AddressEntity> get(Id id);

    void delete(Id id);

    int size();

    AddressEntity generate();

    AddressEntity generateAndSave();
}
