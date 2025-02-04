package pl.tkosinski.accountingadmin.domain.company;

import lombok.Builder;
import lombok.Getter;
import pl.tkosinski.accountingadmin.common.BaseDao;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.common.model.InstitutionName;
import pl.tkosinski.accountingadmin.domain.company.dto.CompanyRequest;

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

    public CompanyDao edit(CompanyRequest request) {
        this.name = request.name();
        this.clientId = request.clientId();
        this.addressId = request.addressId();
        return this;
    }
}
