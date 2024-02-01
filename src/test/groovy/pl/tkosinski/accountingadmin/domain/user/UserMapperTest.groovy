package pl.tkosinski.accountingadmin.domain.user


import spock.lang.Specification

class UserMapperTest extends Specification {

    UserMapper mapper = new UserMapper();

    def "ToDto"() {
    }

    def "should map user dao to dto"() {
        def dao = UserDao.builder()
                .id(616)
                .givenName("Teodor")
                .lastName("Nowak")
                .build()

        when:
        def dto = mapper.toDto(dao)

        then:
        dto.id == dao.id
        dto.givenName == dao.givenName
        dto.lastName == dao.lastName
    }
}
