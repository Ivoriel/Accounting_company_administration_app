package pl.tkosinski.accountingadmin.domain.sample

import pl.tkosinski.accountingadmin.common.model.FullName
import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.domain.user.UserDao
import pl.tkosinski.accountingadmin.domain.user.dto.UserDto

import static pl.tkosinski.accountingadmin.common.model.Role.EMPLOYEE

trait UsesUserSample {

    UserDao.UserDaoBuilder userDaoSample(def args = null) {
        return UserDao.builder()
                .id(Id.ofValue(args?.id ?: 16))
                .role(args?.role ?: EMPLOYEE)
                .name(FullName.ofValue("Teodor", "Nowak"))
    }

    UserDto.UserDtoBuilder userDtoSample(def args = null) {
        return UserDto.builder()
                .id(Id.ofValue(args?.id ?: 16))
                .role(args?.role ?: EMPLOYEE)
                .name(FullName.ofValue("Teodor", "Nowak"))
    }
}