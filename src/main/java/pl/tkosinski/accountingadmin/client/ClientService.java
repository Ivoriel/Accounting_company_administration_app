package pl.tkosinski.accountingadmin.client;

import pl.kosinski.acaa_dto.ClientDto;

public interface ClientService {

    pl.kosinski.acaa_dto.ClientDto save(ClientDto clientDto);

    pl.kosinski.acaa_dto.ClientDto get(Long id);

    void delete(Long id);

}
