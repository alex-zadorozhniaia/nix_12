package com.repository;

import com.model.Auto;

import java.math.BigDecimal;
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
        Optional.ofNullable(autos).isPresent();
        return autos;
    }

    @Override
    public boolean save(Auto auto) {
        if (auto == null) {
            Optional.ofNullable(auto).orElseThrow(IllegalAccessError::new);
        }
        if (auto.getPrice().equals(BigDecimal.ZERO)) {
            auto.setPrice(BigDecimal.valueOf(-1));
        }
        
        autos.add(auto);
        return true;
    }



    @Override
    public boolean saveAll(List<Auto> auto) {
        if (auto != null) {
            Optional.ofNullable(auto).orElse(null);
            return false;
        }

        return autos.addAll(auto);
    }

    @Override
    public boolean create(Auto auto) {
        autos.add(auto);
        Optional.ofNullable(auto).orElseGet(null);
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
    public Optional<Auto> findOneById(String id) {
        Auto result = null;
        for (Auto auto : autos) {
            if (auto .getId().equals(id)) {
                result = auto ;
            }
        }
        return Optional.ofNullable(result);
    }

    public boolean updateByBodyType(String bodyType, Auto copyFrom) {
        for (Auto auto : autos) {
            if (auto.getBodyType().equals(bodyType)) {
                AutoCopy.copy(copyFrom, auto);
            }
        }
        return true;
    }

    private static class AutoCopy {
        static void copy(final Auto from, final Auto to) {

            to.setModel(from.getModel());
            to.setBodyType(from.getBodyType());
            to.setPrice(from.getPrice());
        }
    }
}