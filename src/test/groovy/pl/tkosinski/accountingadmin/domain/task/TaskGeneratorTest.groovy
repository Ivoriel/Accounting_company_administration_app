package pl.tkosinski.accountingadmin.domain.task

import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.domain.company.CompanyFacade
import pl.tkosinski.accountingadmin.domain.user.UserFacade
import spock.lang.Specification

class TaskGeneratorTest extends Specification {

    private final UserFacade userFacade
    private final CompanyFacade companyFacade
    TaskGenerator generator;

    def setup() {
        this.generator = new TaskGenerator()
    }

    def "should generate and return task when user and company facades are provided"() {
        when:
        def generatedDao = generator.generate(userFacade, companyFacade)

        then:
        generatedDao.performerId != null
        generatedDao.clientCompanyId != null
        generatedDao.start != null
        generatedDao.end != null
        generatedDao.title != null
        generatedDao.comment != null
    }

    def "should generate and return task when user and company facades and with start and end params are provided"() {
        when:
        def generatedDao = generator.generate(userFacade, companyFacade, 40, 220)

        then:
        generatedDao.performerId != null
        generatedDao.clientCompanyId != null
        generatedDao.start != null
        generatedDao.end != null
        generatedDao.title != null
        generatedDao.comment != null
    }

    def "should generate and return task when user and company ids are provided"() {
        when:
        def generatedDao = generator.generate(Id.generate(), Id.generate())

        then:
        generatedDao.performerId != null
        generatedDao.clientCompanyId != null
        generatedDao.start != null
        generatedDao.end != null
        generatedDao.title != null
        generatedDao.comment != null
    }

    def "should generate and return task when all parameters are provided"() {
        when:
        def generatedDao = generator.generate(Id.generate(), Id.generate(), 50, 230)

        then:
        generatedDao.performerId != null
        generatedDao.clientCompanyId != null
        generatedDao.start != null
        generatedDao.end != null
        generatedDao.title != null
        generatedDao.comment != null
    }
}
