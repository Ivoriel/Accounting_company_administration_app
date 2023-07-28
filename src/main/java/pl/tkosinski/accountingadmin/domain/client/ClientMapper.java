package pl.tkosinski.accountingadmin.domain.client;

import pl.tkosinski.accountingadmin.domain.client.dto.ClientDto;

public class ClientMapper {

    public static ClientDto toDto(ClientDao dao) {
        return ClientDto.builder()
                .id(dao.getId())
                .name(dao.getName())
                .addressId(dao.getAddressId())
                .build();
    }
}
