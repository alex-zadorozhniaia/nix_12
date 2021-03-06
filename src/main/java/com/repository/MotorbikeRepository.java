package com.repository;



import com.model.Auto;
import com.model.Motorbike;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class MotorbikeRepository implements CrudMotorbikeRepository {
    private final List<Motorbike> moto;
        public MotorbikeRepository() {
            moto = new LinkedList<>();
        }

        @Override
        public Motorbike getById(String id) {
            for (Motorbike motorbike : moto) {
                if (motorbike.getId().equals(id)) {
                    return motorbike;
                }
            }
            return null;
        }

        @Override
        public List<Motorbike> getAll() {
            Optional.ofNullable(null).or((Supplier<? extends Optional<?>>) moto);
            return moto;
        }

    @Override
    public boolean save(Motorbike motorbike) {
        if (motorbike == null) {
            throw new IllegalArgumentException("Motorbike must not be null");
        }
        if (motorbike.getPrice().equals(BigDecimal.ZERO)) {
            motorbike.setPrice(BigDecimal.valueOf(-1));
        }
        moto.add(motorbike);
        return true;
    }



    @Override
    public boolean saveAll(List<Motorbike> motorbike) {
        if (motorbike == null) {
            return false;
        }

        return moto.addAll(motorbike);
    }
    @Override
        public boolean create(Motorbike motorbike) {
            moto.add(motorbike);
            return true;
        }

        @Override
        public boolean create(List<Motorbike> motorbike) {

            return moto.addAll(motorbike);
        }

        @Override
        public boolean update(Motorbike motorbike) {
            final Motorbike founded = getById(motorbike.getId());
            if (founded != null) {
                MotorbikeCopy.copy(motorbike, founded);
                return true;
            }
            return false;
        }

        @Override
        public boolean delete(String id) {
            final Iterator<Motorbike> iterator = moto.iterator();
            while (iterator.hasNext()) {
                final Motorbike motorbike = iterator.next();
                if (motorbike.getId().equals(id)) {
                    iterator.remove();
                    return true;
                }
            }
            return false;
        }
    @Override
    public Optional<Motorbike> findOneById(String id) {
        Motorbike result = null;
        for (Motorbike motorbike : moto) {
            if (motorbike .getId().equals(id)) {
                result = motorbike ;
            }
        }
        return Optional.ofNullable(result);
    }
    public boolean updateByBodyType(String bodyType, Motorbike copyFrom) {
        for (Motorbike motorbike : moto) {
            if (motorbike.getBodyType().equals(bodyType)) {
                MotorbikeRepository.MotorbikeCopy.copy(copyFrom, motorbike);
            }
        }
        return true;
    }

        private static class MotorbikeCopy {
            static void copy(final Motorbike from, final Motorbike to) {

                to.setModel(from.getModel());
                to.setBodyType(from.getBodyType());
                to.setPrice(from.getPrice());
            }
        }

    }
