package pl.tkosinski.accountingadmin.domain.sample

import pl.tkosinski.accountingadmin.common.model.FullName
import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.domain.client.ClientDao
import pl.tkosinski.accountingadmin.domain.client.dto.ClientDto

trait UsesClientSample {

    ClientDao.ClientDaoBuilder clientDaoSample(def args = null) {
        ClientDao.builder()
                .id(Id.ofValue(args?.id ?: 16))
                .name(FullName.ofValue("Teodor", "Nowak"))
                .addressId(Id.ofValue(165))
    }

    ClientDto clientDtoSample(def args = null) {
        return new ClientDto(Id.ofValue(args?.id ?: 16), FullName.ofValue("Teodor", "Nowak"), Id.ofValue(165))
    }
}