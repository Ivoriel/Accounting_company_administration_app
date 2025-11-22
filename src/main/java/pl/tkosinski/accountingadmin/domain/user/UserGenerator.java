package pl.tkosinski.accountingadmin.domain.user;

import pl.tkosinski.accountingadmin.common.generator.FullNameGenerator;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.user.dto.UserDto;

import static pl.tkosinski.accountingadmin.common.model.Role.EMPLOYEE;

class UserGenerator {

    UserDto generate() {
        return new UserDto(
                Id.generate(),
                EMPLOYEE,
                FullNameGenerator.generate());
    }
}