package pl.tkosinski.accountingadmin.domain.client;

import pl.kosinski.acaa_dto.ClientDto;
import pl.tkosinski.accountingadmin.domain.client.dto.ClientDto;

public interface ClientService {

    pl.kosinski.acaa_dto.ClientDto save(ClientDto clientDto);

    pl.kosinski.acaa_dto.ClientDto get(Long id);

    void delete(Long id);

}
