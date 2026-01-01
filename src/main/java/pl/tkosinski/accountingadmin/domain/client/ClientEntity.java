package pl.tkosinski.accountingadmin.domain.client;

import lombok.Builder;
import lombok.Getter;
import pl.tkosinski.accountingadmin.common.BaseDao;
import pl.tkosinski.accountingadmin.common.model.FullName;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.client.dto.ClientRequest;

@Builder
@Getter
class ClientEntity implements BaseDao {

    private final Id id;
    private FullName name;
    private Id addressId;

    public ClientEntity(Id id, FullName name, Id addressId) {
        this.id = id;
        this.name = name;
        this.addressId = addressId;
    }

    public ClientEntity(ClientRequest request) {
        this.id = Id.generate();
        this.name = request.name();
        this.addressId = request.addressId();
    }

    public ClientEntity(Id id, ClientRequest request) {
        this.id = id;
        this.name = request.name();
        this.addressId = request.addressId();
    }

    public ClientEntity edit(ClientRequest request) {
        this.name = request.name();
        this.addressId = request.addressId();
        return this;
    }
}
