package pl.tkosinski.accountingadmin.domain.sample

import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.domain.address.AddressEntity
import pl.tkosinski.accountingadmin.domain.address.dto.AddressDto

trait UsesAddressSample {

    AddressEntity.AddressEntityBuilder addressEntitySample(def args = null) {
        AddressEntity.builder()
                .id(args?.id ?: Id.generate())
                .country("Polska")
                .municipality("Toruń")
                .zipCode("87-100")
                .streetAndBuildingId("Jasna 1, 2p")
    }

    AddressDto addressDtoSample(def args = null) {
        AddressDto.builder()
                .id(args?.id ?: Id.generate())
                .country("Polska")
                .municipality("Toruń")
                .zipCode("87-100")
                .streetAndBuildingId("Jasna 1, 2p")
                .build()
    }
}