package pl.tkosinski.accountingadmin.domain.sample

import pl.tkosinski.accountingadmin.common.model.FullName
import pl.tkosinski.accountingadmin.common.model.Id
import pl.tkosinski.accountingadmin.domain.user.UserDao

import static pl.tkosinski.accountingadmin.common.model.Role.EMPLOYEE

trait UsesUserSample {

    UserDao.UserDaoBuilder userDaoSample(def args = null) {
        UserDao.builder()
                .id(Id.ofValue(args?.id ?: 16))
                .role(EMPLOYEE)
                .name(FullName.ofValue("Teodor", "Nowak"))
    }
}