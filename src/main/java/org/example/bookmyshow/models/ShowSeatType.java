package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "show_seat_types")
public class ShowSeatType extends BaseModel {

   @ManyToOne
   @JoinColumn(name = "show_id")
	private Show show;

   @ManyToOne
   @JoinColumn(name = "seat_type_id")
	private SeatType seatType;
	private Long price;
}
