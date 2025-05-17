package pl.tkosinski.accountingadmin.domain.client;

import pl.tkosinski.accountingadmin.domain.client.dto.ClientDto;

import static pl.tkosinski.accountingadmin.common.exception.code.Utility.UTILITY_CLASS;

class ClientMapper {

    private ClientMapper() {
        throw new IllegalStateException(UTILITY_CLASS.message);
    }

    public static ClientDto toDto(ClientEntity dao) {
        return new ClientDto(dao.getId(), dao.getName(), dao.getAddressId());
    }

    public static ClientEntity toEntity(ClientDto data) {
        return new ClientEntity(data.id(), data.name(), data.addressId());
    }
}
