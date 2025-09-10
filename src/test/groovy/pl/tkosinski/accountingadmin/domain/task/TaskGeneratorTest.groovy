package pl.tkosinski.accountingadmin.domain.task


import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.domain.company.CompanyFacade
import pl.tkosinski.accountingadmin.domain.sample.UsesCompanySample
import pl.tkosinski.accountingadmin.domain.sample.UsesUserSample
import pl.tkosinski.accountingadmin.domain.user.UserFacade
import spock.lang.Specification

class TaskGeneratorTest extends Specification implements UsesUserSample, UsesCompanySample {

    TaskGenerator generator

    def setup() {
        this.generator = new TaskGenerator()
    }

    def "should generate and return task when user and company facades are provided"() {
        given:
        UserFacade userFacade = Mock()
        userFacade.generate() >> userDtoSample()
        CompanyFacade companyFacade = Mock()
        companyFacade.generate() >> companyDtoSample()

        when:
        def generatedDto = generator.generate(userFacade, companyFacade)

        then:
        generatedDto.performerId != null
        generatedDto.clientCompanyId != null
        generatedDto.start != null
        generatedDto.end != null
        generatedDto.title != null
        generatedDto.comment != null
    }

    def "should generate and return task when user and company facades and with start and end params are provided"() {
        given:
        UserFacade userFacade = Mock()
        userFacade.generate() >> userDtoSample()
        CompanyFacade companyFacade = Mock()
        companyFacade.generate() >> companyDtoSample()

        when:
        def generatedDto = generator.generate(userFacade, companyFacade, 40, 220)

        then:
        generatedDto.performerId != null
        generatedDto.clientCompanyId != null
        generatedDto.start != null
        generatedDto.end != null
        generatedDto.title != null
        generatedDto.comment != null
    }

    def "should generate and return task when user and company ids are provided"() {
        when:
        def generatedDto = generator.generate(Id.generate(), Id.generate())

        then:
        generatedDto.performerId != null
        generatedDto.clientCompanyId != null
        generatedDto.start != null
        generatedDto.end != null
        generatedDto.title != null
        generatedDto.comment != null
    }

    def "should generate and return task when all parameters are provided"() {
        when:
        def generatedDto = generator.generate(Id.generate(), Id.generate(), 50, 230)

        then:
        generatedDto.performerId != null
        generatedDto.clientCompanyId != null
        generatedDto.start != null
        generatedDto.end != null
        generatedDto.title != null
        generatedDto.comment != null
    }
}
