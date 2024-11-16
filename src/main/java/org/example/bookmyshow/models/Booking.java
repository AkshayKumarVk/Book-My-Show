package org.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name =  "bookings")
public class Booking extends BaseModel {
   private String number;

   @ManyToOne
   @JoinColumn(name = "user_id")
   private User user;

   @Enumerated(EnumType.ORDINAL)
   private BookingStatus bookingStatus;

   @OneToMany
   @JoinColumn(name = "booking_id")
   private List<Payment> paymentList;
   private Long amount;

   @OneToMany
   @JoinColumn(name = "booking_id")
   private List<ShowSeat> showSeatList;
   private Date bookingTime;

}
