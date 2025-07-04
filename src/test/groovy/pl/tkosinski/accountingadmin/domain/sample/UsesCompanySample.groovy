package pl.tkosinski.accountingadmin.domain.sample

import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.common.model.InstitutionName
import pl.tkosinski.accountingadmin.domain.company.CompanyEntity
import pl.tkosinski.accountingadmin.domain.company.dto.CompanyDto

trait UsesCompanySample {

    CompanyEntity.CompanyEntityBuilder companyEntitySample(def args = null) {
        CompanyEntity.builder()
                .id(args?.id ?: Id.generate())
                .name(InstitutionName.ofValue("Test company name"))
                .addressId(args?.addressId ?: Id.generate())
                .clientId(args?.clientId ?: Id.generate())
    }

    CompanyDto companyDtoSample(def args = null) {
        new CompanyDto(
                args?.id ?: Id.generate(),
                InstitutionName.ofValue("Test company name"),
                args?.addressId ?: Id.generate(),
                args?.clientId ?: Id.generate())
    }
}