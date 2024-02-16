package co.nea.istandvdo.api.user;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record SavedUserDto(
        @NotBlank(message = "You have to fill username......!")  // validation data
        String username,
        @NotBlank(message = "You have to fill familyName...!")
        String familyName,
        @NotBlank(message = "You have to fill givenName....!")
        String givenName,
      //  @NotBlank(message = "You have to fill gender.......!")
        String gender,
    //    @NotBlank(message = "You have to fill date of birth.....!")
        LocalDate dob,
     //   @NotBlank(message = "You have to fill phone.......!")
        String phone,
      //  @NotBlank(message = "You have to fill biography......!")
        String biography,
        // @NotBlank(message = "You have to fill status.......!")
        boolean status)
{}