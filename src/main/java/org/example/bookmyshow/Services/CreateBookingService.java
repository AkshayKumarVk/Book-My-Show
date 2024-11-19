package org.example.bookmyshow.Services;

import org.example.bookmyshow.exceptions.ShowSeatNotFoundException;
import org.example.bookmyshow.exceptions.UserNotFoundException;
import org.example.bookmyshow.models.*;
import org.example.bookmyshow.repositories.BookingRepository;
import org.example.bookmyshow.repositories.ShowSeatRepository;
import org.example.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CreateBookingService {
   private UserRepository userRepository;
   private ShowSeatRepository showSeatRepository;
   private PriceCalculationService priceCalculationService;
   private BookingRepository bookingRepository;

   public CreateBookingService (UserRepository userRepository,
								ShowSeatRepository showSeatRepository,
								PriceCalculationService priceCalculationService,
								BookingRepository bookingRepository) {
	  this.userRepository = userRepository;
	  this.showSeatRepository = showSeatRepository;
	  this.priceCalculationService = priceCalculationService;
	  this.bookingRepository = bookingRepository;
   }


   @Transactional(isolation = Isolation.SERIALIZABLE)
//   the complete createBooking method acquire lock with transaction annotation.
   public Booking createBooking (List<Long> showSeatIds, Long userId)
		   throws UserNotFoundException,
						  ShowSeatNotFoundException {
	  Booking booking = new Booking ();
	  /*
	  1.	Make a DB call and Fetch the user from userId.
	  2.	If the user is unavailable, Throw an exception.
	  3.	Fetch the ShowSeat objects from the DB.
	  4.	Check if the ShowSeats are available,
	  5.	If not, throw an exception
	  -----------------TAKE LOCK------------------
	  6.	Check again the ShowSeat are available.
	  7.	Change the ShowSeat status as BLOCKED.
	  -----------------RELEASE LOCK------------------
	  8.	Create a Booking object with status as PENDING.
	  9.	Move to the Payment page.
	  10.	Return the Booking object with PENDING status.
	   */

//	  Fetch User With userId
	  Optional<User> optionalUser = userRepository.findById (userId);
	  if (optionalUser.isEmpty ()) {
		 throw new UserNotFoundException ("Please Sign up for the best experiences");
	  }
	  User user = optionalUser.get ();
	  booking.setUser (user);
//	  Fetch User With userId

//	  Fetch ShowSeat with showSeatIds
	  List<ShowSeat> showSeatList = showSeatRepository
											.findAllByIdIn (showSeatIds);
	  for (ShowSeat showSeat : showSeatList) {
		 if (!showSeat.getShowSeatStatus ().equals (ShowSeatStatus.AVAILABLE)) {
			throw new ShowSeatNotFoundException ("Something went wrong try again!" +
														 "Show with " + showSeat.getShow ().getId () +
														 " and Seat with " + showSeat.getSeat ().getId () +
														 "Not available");
		 }
	  }

//	  List<ShowSeat> savedShowSeatList = new ArrayList<> ();

	  for (ShowSeat showSeat : showSeatList) {
		 showSeat.setShowSeatStatus (ShowSeatStatus.BLOCKED);
//		 savedShowSeatList.add (showSeatRepository.save (showSeat));
	  }
//	  Fetch ShowSeat with showSeatIds

//	  Move to the payment page

	  booking.setShowSeatList (showSeatList);
	  booking.setBookingStatus (BookingStatus.PENDING);
	  booking.setBookingTime (new Date ());
	  booking.setNumber (new Date () + "123");
	  booking.setAmount (priceCalculationService.calculatePrice (showSeatList));

	  return bookingRepository.save (booking);
   }
}
