package pl.tkosinski.accountingadmin.domain.client

import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.domain.address.AddressFacade
import pl.tkosinski.accountingadmin.domain.sample.UsesAddressSample
import spock.lang.Specification

class ClientGeneratorTest extends Specification implements UsesAddressSample{

    def "should generate and return client given addressId"() {
        given:
        def generator = new ClientGenerator()
        def addressId = Id.generate()

        when:
        def generatedDto = generator.generate(addressId)

        then:
        generatedDto.name() != null
        generatedDto.addressId() != null
    }

    def "should generate and return client given addressFacade"() {
        given:
        def generator = new ClientGenerator()
        AddressFacade addressFacade = Mock()
        addressFacade.generateAndSave() >> addressDtoSample()

        when:
        def generatedDto = generator.generate(addressFacade)

        then:
        generatedDto.name() != null
        generatedDto.addressId() != null
    }
}