package co.nea.istandvdo.api.user.web;

import java.time.LocalDate;

public record UpdateUserDto(Integer id, String uuid, String familyName, String givenName, LocalDate dob,String gender, String phone, String biography) {
}
