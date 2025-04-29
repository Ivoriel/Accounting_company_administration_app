package pl.tkosinski.accountingadmin.domain.client;

import pl.tkosinski.accountingadmin.common.generator.FullNameGenerator;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.client.dto.ClientDto;

public class ClientGenerator {

    public ClientDto generateClient(Id addressId) {
        return new ClientDto(
                Id.generate(),
                FullNameGenerator.generate(),
                addressId);
    }
}
