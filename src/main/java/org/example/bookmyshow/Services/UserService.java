package org.example.bookmyshow.Services;

import org.example.bookmyshow.configs.BcryptEncoderConfig;
import org.example.bookmyshow.dtos.ResponseStatus;
import org.example.bookmyshow.models.User;
import org.example.bookmyshow.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
   private final UserRepository userRepository;
   private final BCryptPasswordEncoder bCryptPasswordEncoder;

   public UserService (UserRepository userRepository,
					   BCryptPasswordEncoder bCryptPasswordEncoder) {
	  this.userRepository = userRepository;
	  this.bCryptPasswordEncoder = bCryptPasswordEncoder;
   }

   public User signup (String username,
					   String email,
					   String password) {

	  Optional<User> optionalUser = userRepository.findByEmail (email);

	  if (optionalUser.isPresent ()) {
		 System.out.println ("User with " + email + " already exists Please login");
//		 Redirect to login page
	  }

	  User user = new User ();

	  user.setUsername (username);
	  user.setEmail (email);

//	  Security
	  user.setPassword (bCryptPasswordEncoder.encode (password));


	  userRepository.save (user);

	  return user;
   }

   public ResponseStatus login (String email,
								String password) {

	  Optional<User> optionalUser = userRepository.findByEmail (email);

	  if (optionalUser.isEmpty ()) {
		 System.out.println ("There is no account with " + email + "Please signup first");
		 return ResponseStatus.FAILED;
	  }

	  User user = optionalUser.get ();

	  if(bCryptPasswordEncoder.matches (password, user.getPassword ())){
		 return ResponseStatus.SUCCESS;
	  }

	  return ResponseStatus.FAILED;
   }
}

