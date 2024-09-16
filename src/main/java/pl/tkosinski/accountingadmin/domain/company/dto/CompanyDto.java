package pl.tkosinski.accountingadmin.domain.company.dto;

import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.common.model.InstitutionName;

public record CompanyDto(Id id, InstitutionName name, Id clientId, Id addressId) {}
