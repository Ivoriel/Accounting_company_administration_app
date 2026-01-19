package pl.tkosinski.accountingadmin.domain.user;

import pl.tkosinski.accountingadmin.domain.user.dto.UserDto;

import static pl.tkosinski.accountingadmin.common.exception.code.Utility.UTILITY_CLASS;

class UserMapper {

    private UserMapper() {
        throw new IllegalStateException(UTILITY_CLASS.message);
    }

    public static UserDto toDto(UserEntity dao) {
        return new UserDto(dao.getId(), dao.getRole(), dao.getName());
    }

    public static UserEntity toEntity(UserDto userDto) {
        return new UserEntity(userDto.id(), userDto.role(), userDto.name());
    }
}
