package pl.tkosinski.accountingadmin.domain.user;

import pl.tkosinski.accountingadmin.domain.user.dto.UserDto;

class UserMapper {

    public static UserDto toDto(UserDao dao) {
        return new UserDto(dao.getId(), dao.getRole(), dao.getName());
    }
}
