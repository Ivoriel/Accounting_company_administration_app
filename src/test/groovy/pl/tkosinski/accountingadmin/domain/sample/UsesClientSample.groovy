package pl.tkosinski.accountingadmin.domain.sample

import pl.tkosinski.accountingadmin.common.model.FullName
import pl.tkosinski.accountingadmin.domain.client.ClientDao

trait UsesClientSample {

    ClientDao.ClientDaoBuilder clientDaoSample() {
        ClientDao.builder()
                .id(16)
                .name(FullName.ofValue("Teodor", "Nowak"))
                .addressId(165)
    }

}