package pl.tkosinski.accountingadmin.domain.client.dto;

import pl.tkosinski.accountingadmin.common.model.FullName;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.user.dto.UserRoleDto;

public record ClientRequest(UserRoleDto userId, ClientDto clientData) {

    public Id id() {
        return clientData.id();
    }

    public FullName name() {
        return clientData.name();
    }

    public Id addressId() {
        return clientData.addressId();
    }
}
