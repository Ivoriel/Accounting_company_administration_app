package pl.tkosinski.accountingadmin.domain.sample

import pl.tkosinski.accountingadmin.common.model.FullName
import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.domain.user.UserEntity
import pl.tkosinski.accountingadmin.domain.user.dto.UserDto

import static pl.tkosinski.accountingadmin.common.model.Role.EMPLOYEE

trait UsesUserSample {

    UserEntity.UserEntityBuilder userDaoSample(def args = null) {
        UserEntity.builder()
                .id(args?.id ?: Id.generate())
                .role(args?.role ?: EMPLOYEE)
                .name(FullName.ofValue("Teodor", "Nowak"))
    }

    UserDto userDtoSample(def args = null) {
        new UserDto(
                args?.id ?: Id.generate(),
                args?.role ?: EMPLOYEE,
                FullName.ofValue("Teodor", "Nowak"))
    }
}