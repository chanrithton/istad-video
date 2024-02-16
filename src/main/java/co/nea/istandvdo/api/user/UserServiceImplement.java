package co.nea.istandvdo.api.user;

import co.nea.istandvdo.api.user.web.UpdateUserDto;
import co.nea.istandvdo.api.user.web.UserDto;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/* AutoConstrutor */
@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImplement implements  UserService {

    private  final UserMapper userMapper;
    private  final UserMap userMap;

    @Override
    public UserDto saveUser(SavedUserDto savedUserDto) {
        User user = userMap.fromSavedUserDto(savedUserDto);

//        log.info("User = {}" ,user);
        user.setUuid(UUID.randomUUID().toString());


        userMapper.insert(user);

        log.info("User = {}" , user);

        Optional<User> userOp = userMapper.selectByID((user.getId()));

        User laterUser = userOp.orElseThrow(() -> new RuntimeException("User is not found"));
        UserDto userDto = userMap.toUserDto(laterUser);

        return userMap.toUserDto(laterUser);
    }

    @Override
    public PageInfo<UserDto> findUsers(int pageSize, int pageNum) {

        PageInfo<User> userDtoPageInfo = PageHelper.startPage(pageNum,pageSize)
                .doSelectPageInfo(() -> userMapper.select(true));
       return  userMap.toUserDtoPageInfo(userDtoPageInfo);
    }

    @Override
    public UserDto findUserByUuid(String uuid) {
        return null;
    }

    @Override
    public void deleteByUuid(String uuid) {

    }

    @Override
    public UserDto updateByUuid(String uuid, UpdateUserDto updateUserDto) {
        return null;
    }
}

