package org.example.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SignupResponseDto {
   private String email;
   private String username;
   private ResponseStatus responseStatus;
}
