package pl.tkosinski.accountingadmin.domain.client;

import lombok.Builder;
import lombok.Getter;
import pl.tkosinski.accountingadmin.common.BaseDao;
import pl.tkosinski.accountingadmin.common.FullName;

@Builder
@Getter
public class ClientDao extends BaseDao {

    private final long id;
    private FullName name;
    private long addressId;

    public ClientDao(long id, FullName name, long addressId) {
        this.id = id;
        this.name = name;
        this.addressId = addressId;
    }

    public ClientDao edit(FullName name, long addressId) {
        this.name = name;
        this.addressId = addressId;
        return this;
    }
}
