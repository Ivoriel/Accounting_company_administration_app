package pl.tkosinski.accountingadmin.domain.client;

import lombok.Builder;
import lombok.Getter;
import pl.tkosinski.accountingadmin.common.BaseDao;
import pl.tkosinski.accountingadmin.common.model.FullName;
import pl.tkosinski.accountingadmin.common.model.Id;

@Builder
@Getter
public class ClientDao extends BaseDao {

    private final Id id;
    private FullName name;
    private Id addressId;

    public ClientDao(Id id, FullName name, Id addressId) {
        this.id = id;
        this.name = name;
        this.addressId = addressId;
    }

    public ClientDao edit(FullName name, Id addressId) {
        this.name = name;
        this.addressId = addressId;
        return this;
    }
}
