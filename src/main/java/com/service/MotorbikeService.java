package com.service;

import com.repository.MotorbikeRepository;
import com.model.Motorbike;
import com.model.MotorbikeManufacturer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class MotorbikeService {


        private static final Logger LOGGER = LoggerFactory.getLogger(MotorbikeService.class);
        private static final Random RANDOM = new Random();
        private final MotorbikeRepository MOTORBIKE_REPOSITORY = new MotorbikeRepository();
    private final MotorbikeRepository motorbikeRepository;


    public MotorbikeService(MotorbikeRepository motorbikeRepository) {
        this.motorbikeRepository = motorbikeRepository;
    }

    public List<Motorbike> createMoto(int count) {
            List<Motorbike> result = new LinkedList<>();
            for (int i = 0; i < count; i++) {
                final Motorbike motorbike = new Motorbike(
                        "Model-" + RANDOM.nextInt(1000),
                        getRandomManufacturer(),
                        BigDecimal.valueOf(RANDOM.nextDouble(1000.0)),
                        "Model-" + RANDOM.nextInt(1000));
                result.add(motorbike);
                LOGGER.debug("Created motorbike {}", motorbike.getId());
            }
            return result;
        }

        private MotorbikeManufacturer getRandomManufacturer() {
            final MotorbikeManufacturer[] values = MotorbikeManufacturer.values();
            final int index = RANDOM.nextInt(values.length);
            return values[index];
        }

    public void saveMoto(List<Motorbike> moto) { MOTORBIKE_REPOSITORY.create(moto);
    }
        public void printAll() {
            for (Motorbike motorbike : MOTORBIKE_REPOSITORY.getAll()) {
                System.out.println(motorbike);
            }
        }

    public void update(Motorbike motorbike){ MOTORBIKE_REPOSITORY.update(motorbike);}

    public List<Motorbike> getAll(){
        return MOTORBIKE_REPOSITORY.getAll();
    }

    public Optional<Motorbike> findOneById(String id){
        return MOTORBIKE_REPOSITORY.findOneById(id);
    }
    public void delete(String id){
        MOTORBIKE_REPOSITORY.delete(id);
    }



}