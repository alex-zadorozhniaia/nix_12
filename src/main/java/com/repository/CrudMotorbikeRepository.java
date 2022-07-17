package com.repository;
import com.model.Motorbike;

import java.util.List;
import java.util.Optional;

public interface CrudMotorbikeRepository {
    Motorbike getById(String id);

    List<Motorbike> getAll();

    boolean save(Motorbike motorbike);
    boolean saveAll(List<Motorbike> motorbike);
    boolean create(Motorbike motorbike);

    boolean create(List<Motorbike> motorbike);

    boolean update(Motorbike motorbike);

    boolean delete(String id);
    public Optional<Motorbike> findOneById(String id);

}
