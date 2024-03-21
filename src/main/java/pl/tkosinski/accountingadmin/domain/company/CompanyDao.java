package pl.tkosinski.accountingadmin.domain.company;

import lombok.Builder;
import lombok.Getter;
import pl.tkosinski.accountingadmin.common.BaseDao;
import pl.tkosinski.accountingadmin.common.model.Id;

@Getter
@Builder
public class CompanyDao extends BaseDao {

    private final Id id;
    private String name;
    private Id clientId;
    private Id addressId;

    public CompanyDao(Id id, String name, Id clientId, Id addressId) {
        this.id = id;
        this.name = name;
        this.clientId = clientId;
        this.addressId = addressId;
    }

    public CompanyDao edit(String name, Id clientId, Id addressId) {
        this.name = name;
        this.clientId = clientId;
        this.addressId = addressId;
        return this;
    }
}
