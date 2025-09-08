package pl.tkosinski.accountingadmin.domain.company

import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.domain.address.AddressFacade
import pl.tkosinski.accountingadmin.domain.client.ClientFacade
import pl.tkosinski.accountingadmin.domain.sample.UsesAddressSample
import pl.tkosinski.accountingadmin.domain.sample.UsesClientSample
import spock.lang.Specification

class CompanyGeneratorTest extends Specification implements UsesClientSample, UsesAddressSample {

    def "should generate and return company given clientId and addressId"() {
        given:
        def generator = new CompanyGenerator()
        def clientId = Id.generate()
        def addressId = Id.generate()

        when:
        def generatedDto = generator.generate(clientId, addressId)

        then:
        generatedDto.name != null
        generatedDto.clientId != null
        generatedDto.addressId != null
    }

    def "should generate and return company given clientFacade and addressFacade"() {
        given:
        def generator = new CompanyGenerator()
        ClientFacade clientFacade = Mock()
        clientFacade.generateAndSave() >> clientDtoSample()
        AddressFacade addressFacade = Mock()
        addressFacade.generateAndSave() >> addressDtoSample()

        when:
        def generatedDto = generator.generate(clientFacade, addressFacade)

        then:
        generatedDto.name != null
        generatedDto.clientId != null
        generatedDto.addressId != null
    }
}
