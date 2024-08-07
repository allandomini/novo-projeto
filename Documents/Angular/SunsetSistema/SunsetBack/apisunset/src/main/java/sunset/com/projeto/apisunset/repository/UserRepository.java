package sunset.com.projeto.apisunset.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sunset.com.projeto.apisunset.model.User;

import java.util.List;
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByNameUser(String nameUser);
    List<User> findByType(String type);
}