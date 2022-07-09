package src.main.java.com.repository;



import src.main.java.com.model.Motorbike;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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
            return moto;
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
    public Optional<Motorbike> findId(String id) {
        Motorbike result = null;
        for (Motorbike motorbike : moto) {
            if (motorbike .getId().equals(id)) {
                result = motorbike ;
            }
        }
        return Optional.ofNullable(result);
    }

        private static class MotorbikeCopy {
            static void copy(final Motorbike from, final Motorbike to) {
                to.setMotorbikeManufacturer(from.getMotorbikeManufacturer());
                to.setModel(from.getModel());
                to.setBodyType(from.getBodyType());
                to.setPrice(from.getPrice());
            }
        }

    }
