package pl.tkosinski.accountingadmin.client;

import lombok.Data;

@Data
public class ClientDto {

    private long id;
    private String name;
    private long addressId;

}
