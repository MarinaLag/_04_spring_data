package by.itclass._02_jpa.repositories;

import by.itclass._02_jpa.entities.Airplane;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface AirplaneRepository extends CrudRepository<Airplane, Integer> {

    //ПРАВИЛО НАЗВАНИЯ МЕТОДА!!!!
    // find,get,query,delete,update
    // по чем By
    // по полям Model, Place и тд

    Airplane findByModel(String model);

    Airplane findByModelAndPlace(String model, int place);

    Airplane findByModelLike(String model);

    Airplane findByIdBetween(int start, int end);

    Airplane findByModelLikeAndPlace(String model, int place);

    Airplane findByModelLikeOrPlace(String model, int place);

    List<Airplane> findByPlaceBetween(int start, int end);


    //import org.springframework.data.jpa.repository.Query;
    // nativeQuery = true - сделай на sql
    @Query(value = "select * from airplane", nativeQuery = true)
    List<Airplane> allPlanes();

    @Query(value = "select * from airplane where model like ?1 and place > ?2", nativeQuery = true)
    List<Airplane> concretePlains(String model, int place);


}
