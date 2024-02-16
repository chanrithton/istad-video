package co.nea.istandvdo.api.user.web;

import co.nea.istandvdo.api.base.Rest;
import co.nea.istandvdo.api.user.SavedUserDto;
import co.nea.istandvdo.api.user.UserServiceImplement;
import com.github.pagehelper.PageInfo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserServiceImplement userServiceImplement;

    @PostMapping
    Rest<Object> saveUser(@Valid @RequestBody SavedUserDto savedUserDto) {

        var userDto = userServiceImplement.saveUser(savedUserDto);

        return Rest.builder()
                .status(true)
                .message("You have retrieved user successfully")
                .code(HttpStatus.OK.value())
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .data(userDto)
                .build();
    }


    @GetMapping
    Rest<?> findUser(@RequestParam(required = false,defaultValue = "20")int pageSize,
                     @RequestParam(required = false,defaultValue = "1") int pageNum){
        PageInfo<UserDto> userDtoPageInfo = userServiceImplement.findUsers(pageSize,pageNum);
        return  Rest.builder()
                .status(true)
                .message("You have created users successfully")
                .code(HttpStatus.OK.value())
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .data(userDtoPageInfo)
                .build();

    }
}
