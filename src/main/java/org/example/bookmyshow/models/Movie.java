package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "movies")
public class Movie extends BaseModel {
   private String name;
//   private List<Actor> cast;
   private Long duration;
   private Long rating;
   private List<String> reviewList;
}
