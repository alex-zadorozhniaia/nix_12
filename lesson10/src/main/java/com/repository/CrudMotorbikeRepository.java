package src.main.java.com.repository;
import src.main.java.com.model.Motorbike;
import java.util.List;
import java.util.Optional;

public interface CrudMotorbikeRepository {
    Motorbike getById(String id);

    List<Motorbike> getAll();

    boolean create(Motorbike motorbike);

    boolean create(List<Motorbike> motorbike);

    boolean update(Motorbike motorbike);

    boolean delete(String id);
    public Optional<Motorbike> findId(String id);
}
