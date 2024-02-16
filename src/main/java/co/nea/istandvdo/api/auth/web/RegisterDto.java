package co.nea.istandvdo.api.auth.web;

public record RegisterDto(String username,String email, String familyName, String givenName, String gender, String password, String confirmedPassword) {

}
