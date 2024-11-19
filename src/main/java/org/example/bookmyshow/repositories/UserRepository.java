package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
   @Override
   Optional<User> findById (Long userId);

   List<User> findAllByEmail (String email);

   Optional<User> findByEmail (String email);
   User save(User user);
}
