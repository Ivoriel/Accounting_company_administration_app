package pl.tkosinski.accountingadmin.domain.company;

import lombok.Data;

@Data
public class CompanyDto {

    private long id;
    private String name;
    private Long clientId;
    private Long addressId;

}
