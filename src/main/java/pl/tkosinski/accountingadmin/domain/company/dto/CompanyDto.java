package pl.tkosinski.accountingadmin.domain.company.dto;

import lombok.Builder;
import lombok.Value;
import pl.tkosinski.accountingadmin.common.model.Id;

@Value
@Builder
public class CompanyDto {

    Id id;
    String name;
    Id clientId;
    Id addressId;

}
