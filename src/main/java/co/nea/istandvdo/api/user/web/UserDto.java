package co.nea.istandvdo.api.user.web;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserDto(String uuid,
         String username,
         String email,
         String familyName,
          String givenName,
         LocalDate dob,
          String gender,
          String phone,
          String profile,
          String biography,
         LocalDateTime createAt,
         boolean status) {
}
