package hako.shareEvent.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import hako.shareEvent.entities.City;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
    List<City> findAll();
}
