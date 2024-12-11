package pl.tkosinski.accountingadmin.domain.client.dto;

import pl.tkosinski.accountingadmin.common.model.FullName;
import pl.tkosinski.accountingadmin.common.model.Id;

public record ClientDto (Id id, FullName name, Id addressId) {}
