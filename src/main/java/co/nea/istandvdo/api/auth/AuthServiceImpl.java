package co.nea.istandvdo.api.auth;

import co.nea.istandvdo.api.auth.web.AuthDto;
import co.nea.istandvdo.api.auth.web.RegisterDto;
import co.nea.istandvdo.api.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements  AuthService{


    private  final  AuthMapper authMapper;
    @Override
    public AuthDto register(RegisterDto registerDto) {
        User user = new User();
        user.setUuid(UUID.randomUUID().toString());
        user.setEmail(registerDto.email());
        user.setUsername(registerDto.username());
        user.setFamilyName(registerDto.familyName());
        user.setGivenName(registerDto.givenName());
        user.setGender(registerDto.gender());
        user.setPassword(registerDto.password());
        authMapper.register(user);

        return new AuthDto(
                user.getEmail(),
                user.getUsername(),
                user.getFamilyName(),
                user.getGivenName(),
                user.getGender()
        );
    }
}
