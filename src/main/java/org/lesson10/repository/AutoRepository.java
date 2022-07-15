package org.lesson10.repository;

import org.lesson10.model.Auto;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class AutoRepository implements CrudRepository {
    private final List<Auto> autos;

    public AutoRepository() {
        autos = new LinkedList<>();
    }

    @Override
    public Auto getById(String id) {
        for (Auto auto : autos) {
            if (auto.getId().equals(id)) {
                return auto;
            }
        }
        return null;
    }

    @Override
    public List<Auto> getAll() {
        return autos;
    }

    @Override
    public boolean save(Auto auto) {
        return false;
    }

    @Override
    public boolean saveAll(List<Auto> auto) {
        return false;
    }

    @Override
    public boolean create(Auto auto) {
        autos.add(auto);
        return true;
    }

    @Override
    public boolean create(List<Auto> auto) {
        return autos.addAll(auto);
    }

    @Override
    public boolean update(Auto auto) {
        final Auto founded = getById(auto.getId());
        if (founded != null) {
            AutoCopy.copy(auto, founded);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        final Iterator<Auto> iterator = autos.iterator();
        while (iterator.hasNext()) {
            final Auto auto = iterator.next();
            if (auto.getId().equals(id)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
    @Override
    public Optional<Auto> findId(String id) {
        Auto result = null;
        for (Auto auto : autos) {
            if (auto .getId().equals(id)) {
                result = auto ;
            }
        }
        return Optional.ofNullable(result);
    }
    private static class AutoCopy {
        static void copy(final Auto from, final Auto to) {
            to.setManufacturer(from.getManufacturer());
            to.setModel(from.getModel());
            to.setBodyType(from.getBodyType());
            to.setPrice(from.getPrice());
        }
    }
}