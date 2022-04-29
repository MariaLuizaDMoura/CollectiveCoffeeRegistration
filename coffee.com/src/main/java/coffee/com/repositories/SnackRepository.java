package coffee.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coffee.com.entities.SnackEntity;

@Repository
public interface SnackRepository extends JpaRepository<SnackEntity, Integer>{

}
