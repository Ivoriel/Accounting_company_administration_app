package pl.tkosinski.accountingadmin.domain.company;

import pl.tkosinski.accountingadmin.domain.company.dto.CompanyDto;

public class CompanyMapper {

    public static CompanyDto toDto(CompanyDao companyDao) {
        CompanyDto dto = new CompanyDto();
        dto.setId(companyDao.getId());
        dto.setName(companyDao.getName());
        dto.setClientId(companyDao.getClientId());
        dto.setAddressId(companyDao.getAddressId());
        return dto;
    }
}
