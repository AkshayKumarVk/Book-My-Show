package org.example.bookmyshow.controllers;

import lombok.Getter;
import lombok.Setter;
import org.example.bookmyshow.Services.CreateBookingService;
import org.example.bookmyshow.dtos.CreateBookingRequestDto;
import org.example.bookmyshow.dtos.CreateBookingResponseDto;
import org.example.bookmyshow.dtos.ResponseStatus;
import org.example.bookmyshow.exceptions.ShowSeatNotFoundException;
import org.example.bookmyshow.exceptions.UserNotFoundException;
import org.example.bookmyshow.models.Booking;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter

@RestController
@RequestMapping("/booking")
public class BookingController {

   private CreateBookingService bookingService;

   public BookingController (CreateBookingService bookingService) {
	  this.bookingService = bookingService;
   }


   @PostMapping()
   public CreateBookingResponseDto createBooking (@RequestBody CreateBookingRequestDto requestDto)
		   throws UserNotFoundException,
						  ShowSeatNotFoundException {

	  CreateBookingResponseDto responseDto = new CreateBookingResponseDto ();
	  Booking booking = null;

	  booking = bookingService.createBooking (
			  requestDto.getShowSeatIds (),
			  requestDto.getUserId ()
	  );

	  if (booking == null) {
		 responseDto.setResponseStatus (ResponseStatus.FAILED);
	  }

	  responseDto.setBooking (booking);
	  responseDto.setResponseStatus (ResponseStatus.SUCCESS);

	  return responseDto;
   }
}
