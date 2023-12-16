package pl.tkosinski.accountingadmin.domain.client;

import pl.tkosinski.accountingadmin.domain.client.dto.ClientDto;

public class ClientMapper {

    public static ClientDto toDto(ClientDao dao) {
        return ClientDto.builder()
                .id(dao.getId())
                .givenName(dao.getGivenName())
                .lastName(dao.getLastName())
                .addressId(dao.getAddressId())
                .build();
    }
}
