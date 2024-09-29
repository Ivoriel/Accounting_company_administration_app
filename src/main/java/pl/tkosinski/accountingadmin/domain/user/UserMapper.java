package pl.tkosinski.accountingadmin.domain.user;

import pl.tkosinski.accountingadmin.domain.user.dto.UserDto;

import static pl.tkosinski.accountingadmin.common.exception.code.Utility.UTILITY_CLASS;

class UserMapper {

    private UserMapper() {
        throw new IllegalStateException(UTILITY_CLASS.message);
    }

    public static UserDto toDto(UserDao dao) {
        return new UserDto(dao.getId(), dao.getRole(), dao.getName());
    }
}
