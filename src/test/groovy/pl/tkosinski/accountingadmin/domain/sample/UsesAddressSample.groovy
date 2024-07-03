package pl.tkosinski.accountingadmin.domain.sample

import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.domain.address.AddressDao
import pl.tkosinski.accountingadmin.domain.address.dto.AddressDto

import java.util.concurrent.ThreadLocalRandom

trait UsesAddressSample {

    AddressDao.AddressDaoBuilder addressDaoSample(def args = null) {
        AddressDao.builder()
                .id(Id.ofValue(args?.id ?: 125))
                .country("Polska")
                .municipality("Toruń")
                .region("kujawsko-pomorskie")
                .zipCode("87-100")
                .street("Jasna")
                .buildingNumber("1")
                .additionalIdentifier("2p")
    }

    AddressDto.AddressDtoBuilder addressDtoSample(def args = null) {
        AddressDto.builder()
                .id(Id.ofValue(args?.id ?: 125))
                .country("Polska")
                .municipality("Toruń")
                .region("kujawsko-pomorskie")
                .zipCode("87-100")
                .street("Jasna")
                .buildingNumber("1")
                .additionalIdentifier("2p")
    }
}