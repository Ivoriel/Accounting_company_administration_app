package pl.tkosinski.accountingadmin.domain.client;

import pl.tkosinski.accountingadmin.domain.client.dto.ClientDto;

public interface ClientService {

    ClientDto save(ClientDto clientDto);

    ClientDto get(Long id);

    void delete(Long id);

}
