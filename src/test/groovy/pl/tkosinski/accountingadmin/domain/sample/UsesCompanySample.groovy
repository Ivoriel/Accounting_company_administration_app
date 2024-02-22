package pl.tkosinski.accountingadmin.domain.sample

import pl.tkosinski.accountingadmin.domain.company.CompanyDao

trait UsesCompanySample {

    CompanyDao.CompanyDaoBuilder companyDaoSample() {
        CompanyDao.builder()
                .id(616)
                .name("Test company name")
                .addressId(919)
                .clientId(818)
    }

}