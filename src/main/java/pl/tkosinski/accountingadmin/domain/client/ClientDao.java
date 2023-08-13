package pl.tkosinski.accountingadmin.domain.client;

import lombok.Builder;
import lombok.Getter;
import pl.tkosinski.accountingadmin.common.BaseDao;

@Builder
@Getter
public class ClientDao extends BaseDao {

    private final long id;
    private String name;
    private long addressId;

    public ClientDao(long id, String name, long addressId) {
        this.id = id;
        this.name = name;
        this.addressId = addressId;
    }

    public ClientDao edit(String name, long addressId) {
        this.name = name;
        this.addressId = addressId;
        return this;
    }
}
