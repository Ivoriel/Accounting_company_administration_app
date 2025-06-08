package pl.tkosinski.accountingadmin.domain.task

import pl.tkosinski.accountingadmin.common.model.Id
import spock.lang.Specification

class TaskGeneratorTest extends Specification {

    TaskGenerator generator;

    def setup() {
        this.generator = new TaskGenerator()
    }

    def "Generate"() {
    }

    def "TestGenerate"() {
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
