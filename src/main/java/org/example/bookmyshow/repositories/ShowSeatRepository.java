package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.Show;
import org.example.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

//   select * from show_seats where id IN(1,2,4,3,5,)


   //   List<ShowSeat> findAllById (List<Long> showSeatIds);

   List<ShowSeat> findAllByIdIn(List<Long> ids);


//   @Query("select s from show_seats  s where s.id in : ids ")
//   List<ShowSeat> findSeatByIds(@Param ("ids") List<Long> ids);
}