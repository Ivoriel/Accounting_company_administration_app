package pl.tkosinski.accountingadmin.domain.sample

import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.domain.address.AddressDao

trait UsesAddressSample {

    AddressDao.AddressDaoBuilder addressDaoSample() {
        AddressDao.builder()
                .id(Id.ofValue(125))
                .country("Polska")
                .municipality("Toruń")
                .region("kujawsko-pomorskie")
                .zipCode("87-100")
                .street("Jasna")
                .buildingNumber("1")
                .additionalIdentifier("2p")
    }
}