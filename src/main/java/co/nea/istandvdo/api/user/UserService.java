package co.nea.istandvdo.api.user;

import co.nea.istandvdo.api.user.web.UpdateUserDto;
import co.nea.istandvdo.api.user.web.UserDto;
import com.github.pagehelper.PageInfo;

public interface UserService {

    UserDto saveUser(SavedUserDto savedUserDto);


    PageInfo<UserDto> findUsers(int pageSize, int pageNum);

    UserDto findUserByUuid(String uuid);

    void deleteByUuid(String uuid);

    UserDto updateByUuid(String uuid, UpdateUserDto updateUserDto);
}
