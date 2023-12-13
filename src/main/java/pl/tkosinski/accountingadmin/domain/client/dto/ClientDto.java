package pl.tkosinski.accountingadmin.domain.client.dto;

import lombok.*;

import static lombok.AccessLevel.PRIVATE;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = PRIVATE, force = true)
public class ClientDto {

    long id;
    String givenName;
    String lastName;
    long addressId;

}
