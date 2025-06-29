package pl.tkosinski.accountingadmin.domain.company;

import pl.tkosinski.accountingadmin.domain.company.dto.CompanyDto;

import static pl.tkosinski.accountingadmin.common.exception.code.Utility.UTILITY_CLASS;

class CompanyMapper {

    private CompanyMapper() {
        throw new IllegalStateException(UTILITY_CLASS.message);
    }

    public static CompanyDto toDto(CompanyEntity companyEntity) {
        return new CompanyDto(companyEntity.getId(), companyEntity.getName(), companyEntity.getClientId(),
        companyEntity.getAddressId());
    }

    public static CompanyEntity toDao(CompanyDto dto) {
        return new CompanyEntity(dto);
    }
}
