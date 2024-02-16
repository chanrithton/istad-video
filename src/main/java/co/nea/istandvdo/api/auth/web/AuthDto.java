package co.nea.istandvdo.api.auth.web;


public record AuthDto(String email,
                      String username,
                      String familyName,
                      String givenName,
                      String gender
) {}
