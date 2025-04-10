package pl.tkosinski.accountingadmin.domain.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import pl.tkosinski.accountingadmin.common.BaseDao;
import pl.tkosinski.accountingadmin.common.model.FullName;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.client.dto.ClientRequest;

import static lombok.AccessLevel.PRIVATE;

@Builder
@Getter
@AllArgsConstructor(access = PRIVATE)
class ClientDao implements BaseDao {

    private final Id id;
    private FullName name;
    private Id addressId;

    public ClientDao(Id id, ClientRequest request) {
        this.id = id;
        this.name = request.name();
        this.addressId = request.addressId();
    }

    public ClientDao edit(ClientRequest request) {
        this.name = request.name();
        this.addressId = request.addressId();
        return this;
    }
}
