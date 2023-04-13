package pl.tkosinski.accountingadmin.domain.client.dto;

import lombok.Data;

@Data
public class ClientDto {

    private long id;
    private String name;
    private long addressId;

}
