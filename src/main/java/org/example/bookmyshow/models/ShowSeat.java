package org.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "show_seats")
public class ShowSeat extends BaseModel {

   @ManyToOne
   @JoinColumn(name = "show_id")
   private Show show;

   @ManyToOne
   @JoinColumn(name = "seat_id")
   private Seat seat;

   @Enumerated(EnumType.ORDINAL)
   private ShowSeatStatus showSeatStatus;
}
