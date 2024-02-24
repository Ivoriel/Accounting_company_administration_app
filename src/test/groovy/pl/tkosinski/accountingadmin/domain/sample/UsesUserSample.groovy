package pl.tkosinski.accountingadmin.domain.sample

import pl.tkosinski.accountingadmin.common.FullName
import pl.tkosinski.accountingadmin.domain.user.UserDao

trait UsesUserSample {

    UserDao.UserDaoBuilder userDaoSample() {
        UserDao.builder()
                .id(616)
                .name(FullName.ofValue("Teodor", "Nowak"))
    }
}