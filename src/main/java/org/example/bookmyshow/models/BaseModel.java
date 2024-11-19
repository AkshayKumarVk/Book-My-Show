package org.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners (AuditingEntityListener.class)
public abstract class BaseModel {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @CreatedDate
   private Date createdAt;
   @LastModifiedDate
   private Date updatedAt;
}

/*
@EnableJpaAuditing => Project Level
@EntityListener(AuditingEntityListener.class) => Entity Level
@CreatedDate, @LastModifiedDate => Attribute Level
 */
