package pl.tkosinski.accountingadmin.domain.company.dto;

import lombok.Data;

@Data
public class CompanyDto {

    private long id;
    private String name;
    private Long clientId;
    private Long addressId;

}
