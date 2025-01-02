package pl.tkosinski.accountingadmin.domain.sample

import pl.tkosinski.accountingadmin.common.model.FullName
import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.domain.user.UserDao
import pl.tkosinski.accountingadmin.domain.user.dto.UserDto

import static pl.tkosinski.accountingadmin.common.model.Role.EMPLOYEE

trait UsesUserSample {

    UserDao userDaoSample(def args = null) {
        new UserDao(Id.ofValue(args?.id ?: 16),
                args?.role ?: EMPLOYEE,
                FullName.ofValue("Teodor", "Nowak"))
    }

    UserDto userDtoSample(def args = null) {
        new UserDto(
                Id.ofValue(args?.id ?: 16),
                args?.role ?: EMPLOYEE,
                FullName.ofValue("Teodor", "Nowak"))
    }
}