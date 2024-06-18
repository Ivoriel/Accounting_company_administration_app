package pl.tkosinski.accountingadmin.domain.user;

import pl.tkosinski.accountingadmin.domain.user.dto.UserDto;

public class UserMapper {

    public static UserDto toDto(UserDao dao) {
        return UserDto.builder()
                .id(dao.getId())
                .role(dao.getRole())
                .name(dao.getName())
                .build();
    }
}
