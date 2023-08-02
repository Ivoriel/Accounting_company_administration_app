package pl.tkosinski.accountingadmin.domain.company;

import pl.tkosinski.accountingadmin.domain.company.dto.CompanyDto;

public class CompanyMapper {

    public static CompanyDto toDto(CompanyDao companyDao) {
        return CompanyDto.builder()
                .id(companyDao.getId())
                .name(companyDao.getName())
                .clientId(companyDao.getClientId())
                .addressId(companyDao.getAddressId())
                .build();
    }
}
