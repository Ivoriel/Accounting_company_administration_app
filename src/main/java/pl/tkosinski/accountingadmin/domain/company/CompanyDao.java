package pl.tkosinski.accountingadmin.domain.company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import pl.tkosinski.accountingadmin.common.BaseDao;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.common.model.InstitutionName;
import pl.tkosinski.accountingadmin.domain.company.dto.CompanyDto;
import pl.tkosinski.accountingadmin.domain.company.dto.CompanyRequest;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Builder
@AllArgsConstructor(access = PRIVATE)
class CompanyDao implements BaseDao {

    private final Id id;
    private InstitutionName name;
    private Id clientId;
    private Id addressId;

    public CompanyDao(Id id, CompanyRequest request) {
        this.id = id;
        this.name = request.name();
        this.clientId = request.clientId();
        this.addressId = request.addressId();
    }

    public CompanyDao(CompanyDto dto) {
        this.id = dto.id();
        this.name = dto.name();
        this.clientId = dto.clientId();
        this.addressId = dto.addressId();
    }

    public CompanyDao edit(CompanyRequest request) {
        this.name = request.name();
        this.clientId = request.clientId();
        this.addressId = request.addressId();
        return this;
    }
}
