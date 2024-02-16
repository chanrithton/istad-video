package co.nea.istandvdo.api.auth.web;

import co.nea.istandvdo.api.auth.AuthServiceImpl;
import co.nea.istandvdo.api.base.Rest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/v1/auth")
public class AuthRestController {

    private  final AuthServiceImpl authServiceImpl;
    @PostMapping("register")
    Rest<?> register(@RequestBody RegisterDto registerDto){


        log.info("Resgister DTO = {}", registerDto);
        var authDto = authServiceImpl.register(registerDto);


        return  Rest.builder()
                .status(true)
                .message("You have retrieved user successfully")
                .code(HttpStatus.OK.value())
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .data(authDto)
                .build();
    }

}
