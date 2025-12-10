package pl.tkosinski.accountingadmin.domain.address


import spock.lang.Specification

class AddressGeneratorTest extends Specification {

    def "should generate and return address"() {
        given:
        def generator = new AddressGenerator()

        when:
        def generatedDto = generator.generate()

        then:
        generatedDto.country() != null
        generatedDto.municipality() != null
        generatedDto.zipCode() != null
        generatedDto.streetAndBuildingId() != null
    }
}
