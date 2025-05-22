package pl.tkosinski.accountingadmin.domain.company

import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.domain.address.AddressFacade
import pl.tkosinski.accountingadmin.domain.client.ClientFacade
import spock.lang.Specification

class CompanyGeneratorTest extends Specification {

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
        def clientFacade = new ClientFacade()
        def addressFacade = new AddressFacade()

        when:
        def generatedDto = generator.generate(clientFacade, addressFacade)

        then:
        generatedDto.name != null
        generatedDto.clientId != null
        generatedDto.addressId != null
    }
}
