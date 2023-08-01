package pl.tkosinski.accountingadmin.domain.company.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CompanyDto {

    long id;
    String name;
    Long clientId;
    Long addressId;

}
