package by.itclass._02_jpa.repositories;

import by.itclass._02_jpa.entities.Passenger;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface PassengerRepository extends CrudRepository<Passenger, Integer> {

}
