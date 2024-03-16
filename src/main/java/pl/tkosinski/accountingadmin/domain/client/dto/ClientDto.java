package pl.tkosinski.accountingadmin.domain.client.dto;

import lombok.*;
import pl.tkosinski.accountingadmin.common.FullName;
import pl.tkosinski.accountingadmin.common.model.Id;

import static lombok.AccessLevel.PRIVATE;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = PRIVATE, force = true)
public class ClientDto {

    Id id;
    FullName name;
    Id addressId;

}
