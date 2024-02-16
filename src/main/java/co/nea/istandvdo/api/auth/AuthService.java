package co.nea.istandvdo.api.auth;

import co.nea.istandvdo.api.auth.web.AuthDto;
import co.nea.istandvdo.api.auth.web.RegisterDto;

public interface AuthService {

    AuthDto register(RegisterDto registerDto);
}
