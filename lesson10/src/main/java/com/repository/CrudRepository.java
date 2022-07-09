package src.main.java.com.repository;

import src.main.java.com.model.Auto;

import java.util.List;
import java.util.Optional;

public interface CrudRepository {
    Auto getById(String id);

    List<Auto> getAll();

    boolean save(Auto auto);

    boolean saveAll(List<Auto> auto);

    boolean create(Auto auto);

    boolean create(List<Auto> auto);

    boolean update(Auto auto);

    boolean delete(String id);
    Optional<Auto> findId(String id);
}
