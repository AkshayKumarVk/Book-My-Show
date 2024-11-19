package org.example.bookmyshow.Services;

import org.example.bookmyshow.models.ShowSeat;
import org.example.bookmyshow.models.ShowSeatType;
import org.example.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculationService {
   private final ShowSeatTypeRepository showSeatTypeRepository;

   public PriceCalculationService (ShowSeatTypeRepository showSeatRepository) {
	  this.showSeatTypeRepository = showSeatRepository;
   }

   public Long calculatePrice (List<ShowSeat> showSeatList) {
	  Long amount = 0L;

	  List<ShowSeatType> showSeatTypeList = showSeatTypeRepository.findAllByShow (showSeatList.get (0).getShow ());

	  for (ShowSeat showSeat : showSeatList) {
		 for (ShowSeatType showSeatType : showSeatTypeList) {
			if (showSeat.getSeat ().getSeatType ().equals (showSeatType.getSeatType ())) {
			   amount += showSeatType.getPrice ();
			   break;
			}
		 }
	  }
	  return amount;
   }
}
