package org.example.bookmyshow.controllers;

import lombok.Getter;
import org.example.bookmyshow.dtos.*;
import org.example.bookmyshow.dtos.ResponseStatus;
import org.example.bookmyshow.models.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
   private final org.example.bookmyshow.Services.UserService userService;

   public UserController (org.example.bookmyshow.Services.UserService userService) {
	  this.userService = userService;
   }

   @PostMapping("/signup")
   public SignupResponseDto signUpUser (@RequestBody SignUpRequestDto requestDto) {
	  User user = userService.signup (requestDto.getUsername (),
			  requestDto.getEmail (),
			  requestDto.getPassword ());

	  SignupResponseDto responseDto = new SignupResponseDto ();
	  responseDto.setEmail (user.getEmail ());
	  responseDto.setUsername (user.getUsername ());
	  responseDto.setResponseStatus (ResponseStatus.SUCCESS);


	  return responseDto;
   }

   @GetMapping("/login")
   public LoginResponseDto login (@RequestBody LoginRequestDto requestDto) {
	  LoginResponseDto responseDto = new LoginResponseDto ();
	  responseDto.setResponseStatus(userService.login (
			  requestDto.getEmail (),
			  requestDto.getPassword ()
	  ));
	  return responseDto;
   }

}
