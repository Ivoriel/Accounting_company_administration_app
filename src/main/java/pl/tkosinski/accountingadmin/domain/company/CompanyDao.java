package pl.tkosinski.accountingadmin.domain.company;

import lombok.Builder;
import lombok.Getter;
import pl.tkosinski.accountingadmin.common.BaseDao;

@Getter
@Builder
public class CompanyDao extends BaseDao {

    private final long id;
    private String name;
    private long clientId;
    private long addressId;

    public CompanyDao(long id, String name, long clientId, long addressId) {
        this.id = id;
        this.name = name;
        this.clientId = clientId;
        this.addressId = addressId;
    }

    public CompanyDao edit(String name, long clientId, long addressId) {
        this.name = name;
        this.clientId = clientId;
        this.addressId = addressId;
        return this;
    }

    @Override
    public long getId() {
        return id;
    }
}
