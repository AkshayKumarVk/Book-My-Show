package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {

   private int rowNO;
   private int colNo;
   private String name;

   @ManyToOne
   @JoinColumn(name = "seat_type_id")
   private SeatType seatType;
}
