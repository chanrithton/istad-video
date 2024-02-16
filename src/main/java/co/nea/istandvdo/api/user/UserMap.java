package co.nea.istandvdo.api.user;

import co.nea.istandvdo.api.user.web.UserDto;
import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMap {

    User fromSavedUserDto(SavedUserDto savedUserDto);
    UserDto toUserDto(User user);

    PageInfo<UserDto> toUserDtoPageInfo(PageInfo<User> userPageInfo);
}
