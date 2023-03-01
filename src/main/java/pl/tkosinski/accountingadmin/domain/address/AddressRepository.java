package pl.tkosinski.accountingadmin.domain.address;

import pl.kosinski.acaa_dao.Common.BaseRepository;
import pl.kosinski.acaa_dto.AddressDto;

import java.util.Optional;

public interface AddressRepository extends BaseRepository {

    AddressDao save(AddressDao addressDao);

    Optional<AddressDao> get(long id);

    void delete(long id);

    int size();

    AddressDto generate();

}
