package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.Show;
import org.example.bookmyshow.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {

//   select * from show_seat_types where show_id = 121

   List<ShowSeatType> findAllByShow (Show show);
//   finding all the show seat type by show

//   123 GOLD 500
//   123 SILVER 250
}
