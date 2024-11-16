package org.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "screens")
public class Screen extends BaseModel {
   private String name;

   @Enumerated(EnumType.ORDINAL)
   @ElementCollection
   private List<Feature> featureList;

   @OneToMany
   @JoinColumn(name ="screen_id")
   private List<Seat> seatList;

   @Enumerated(EnumType.ORDINAL)
   private ScreenStatus screenStatus;
}
