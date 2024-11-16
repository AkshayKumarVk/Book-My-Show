package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "theatres")
public class Theatre extends BaseModel {

   @OneToOne
   private Address address;

   @OneToMany
   @JoinColumn(name = "theatre_id")
   private List<Screen> screenList;
}
