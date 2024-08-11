package pl.tkosinski.accountingadmin.domain.sample

import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.common.model.InstitutionName
import pl.tkosinski.accountingadmin.domain.company.CompanyDao
import pl.tkosinski.accountingadmin.domain.company.dto.CompanyDto

trait UsesCompanySample {

    CompanyDao.CompanyDaoBuilder companyDaoSample(def args = null) {
        CompanyDao.builder()
                .id(Id.ofValue(args?.id ?: 16))
                .name(InstitutionName.ofValue("Test company name"))
                .addressId(Id.ofValue(919))
                .clientId(Id.ofValue(818))
    }

    CompanyDto.CompanyDtoBuilder companyDtoSample(def args = null) {
        CompanyDto.builder()
                .id(Id.ofValue(args?.id ?: 16))
                .name(InstitutionName.ofValue("Test company name"))
                .addressId(Id.ofValue(919))
                .clientId(Id.ofValue(818))
    }
}