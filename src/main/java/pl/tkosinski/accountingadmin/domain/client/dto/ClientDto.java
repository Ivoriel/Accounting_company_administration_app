package pl.tkosinski.accountingadmin.domain.client.dto;

import lombok.*;
import pl.tkosinski.accountingadmin.common.FullName;

import static lombok.AccessLevel.PRIVATE;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = PRIVATE, force = true)
public class ClientDto {

    long id;
    FullName name;
    long addressId;

}
