package pl.tkosinski.accountingadmin.domain.company.dto;

import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.common.model.InstitutionName;
import pl.tkosinski.accountingadmin.domain.user.dto.UserRoleDto;

public record CompanyRequest(UserRoleDto userId, Id id, InstitutionName name, Id clientId, Id addressId) {}
