package pl.tkosinski.accountingadmin.domain.company;

import pl.tkosinski.accountingadmin.domain.company.dto.CompanyDto;

import static pl.tkosinski.accountingadmin.common.exception.code.Utility.UTILITY_CLASS;

class CompanyMapper {

    private CompanyMapper() {
        throw new IllegalStateException(UTILITY_CLASS.message);
    }

    public static CompanyDto toDto(CompanyDao companyDao) {
        return new CompanyDto(companyDao.getId(), companyDao.getName(), companyDao.getClientId(),
        companyDao.getAddressId());
    }

    public static CompanyDao toDao(CompanyDto dto) {
        return new CompanyDao(dto);
    }
}
