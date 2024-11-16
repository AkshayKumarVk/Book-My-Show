package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "payments")
public class Payment extends BaseModel {
   private Long amount;

   @Enumerated(EnumType.ORDINAL)
   private PaymentStatus paymentStatus;
   private String referenceNo;

   @Enumerated(EnumType.ORDINAL)
   private PaymentMode paymentMode;

}
