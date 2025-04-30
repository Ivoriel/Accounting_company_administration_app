package pl.tkosinski.accountingadmin.domain.client

import pl.tkosinski.accountingadmin.common.model.Id
import spock.lang.Specification

class ClientGeneratorTest extends Specification {

    def "should generate and return client"() {
        given:
        def generator = new ClientGenerator()
        def addressId = Id.generate()

        when:
        def generatedDto = generator.generate(addressId)

        then:
        generatedDto.name() != null
        generatedDto.addressId() != null
    }

    def TestGenerate() {
    }
}
