package pl.tkosinski.accountingadmin.domain.company;

import lombok.Builder;
import lombok.Getter;
import pl.tkosinski.accountingadmin.common.BaseDao;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.common.model.InstitutionName;

@Getter
@Builder
class CompanyDao extends BaseDao {

    private final Id id;
    private InstitutionName name;
    private Id clientId;
    private Id addressId;

    public CompanyDao(Id id, InstitutionName name, Id clientId, Id addressId) {
        this.id = id;
        this.name = name;
        this.clientId = clientId;
        this.addressId = addressId;
    }

    public CompanyDao edit(InstitutionName name, Id clientId, Id addressId) {
        this.name = name;
        this.clientId = clientId;
        this.addressId = addressId;
        return this;
    }
}
