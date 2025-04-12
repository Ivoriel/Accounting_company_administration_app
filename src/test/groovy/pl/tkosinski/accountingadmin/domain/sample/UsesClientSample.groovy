package pl.tkosinski.accountingadmin.domain.sample

import pl.tkosinski.accountingadmin.common.model.FullName
import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.domain.client.ClientDao
import pl.tkosinski.accountingadmin.domain.client.dto.ClientDto

trait UsesClientSample {

    ClientDao.ClientDaoBuilder clientDaoSample(def args = null) {
        ClientDao.builder()
                .id(args?.id ?: Id.generate())
                .name(FullName.ofValue("Teodor", "Nowak"))
                .addressId(Id.generate())
    }

    ClientDto clientDtoSample(def args = null) {
        return new ClientDto(args?.id ?: Id.generate(), FullName.ofValue("Teodor", "Nowak"), Id.generate())
    }
}