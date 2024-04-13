package pl.tkosinski.accountingadmin.domain.sample

import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.common.model.InstitutionName
import pl.tkosinski.accountingadmin.domain.company.CompanyDao

trait UsesCompanySample {

    CompanyDao.CompanyDaoBuilder companyDaoSample() {
        CompanyDao.builder()
                .id(Id.ofValue(616))
                .name(InstitutionName.ofValue("Test company name"))
                .addressId(Id.ofValue(919))
                .clientId(Id.ofValue(818))
    }

}