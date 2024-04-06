package pl.tkosinski.accountingadmin.domain.company.dto;

import lombok.Builder;
import lombok.Value;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.common.model.InstitutionName;

@Value
@Builder
public class CompanyDto {

    Id id;
    InstitutionName name;
    Id clientId;
    Id addressId;

}
