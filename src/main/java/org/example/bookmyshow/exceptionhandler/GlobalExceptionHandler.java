package org.example.bookmyshow.exceptionhandler;

import org.example.bookmyshow.exceptions.ShowSeatNotFoundException;
import org.example.bookmyshow.exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(UserNotFoundException.class)
   public void handleUserNotFoundException(){
	  System.out.println ("Please login for the better user experience.");
   }

   @ExceptionHandler(ShowSeatNotFoundException.class)
   public void seatNotFoundException(){
	  System.out.println ("Something went wrong please come again");
   }
}
