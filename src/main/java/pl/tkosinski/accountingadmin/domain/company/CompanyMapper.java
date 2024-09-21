package pl.tkosinski.accountingadmin.domain.company;

import pl.tkosinski.accountingadmin.domain.company.dto.CompanyDto;

class CompanyMapper {

    public static CompanyDto toDto(CompanyDao companyDao) {
        return new CompanyDto(companyDao.getId(), companyDao.getName(), companyDao.getClientId(),
        companyDao.getAddressId());
    }
}
