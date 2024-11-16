package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "addresses")
public class Address extends BaseModel {
   private String name;
   private String location;
   private String phoneNo;
}
