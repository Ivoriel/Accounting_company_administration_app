package pl.tkosinski.accountingadmin.domain.client;

import pl.tkosinski.accountingadmin.domain.client.dto.ClientDto;

import static pl.tkosinski.accountingadmin.common.exception.code.Utility.UTILITY_CLASS;

class ClientMapper {

    private ClientMapper() {
        throw new IllegalStateException(UTILITY_CLASS.message);
    }

    public static ClientDto toDto(ClientDao dao) {
        return ClientDto.builder()
                .id(dao.getId())
                .name(dao.getName())
                .addressId(dao.getAddressId())
                .build();
    }
}
