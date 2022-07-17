package com.service;

import com.repository.AutoRepository;
import com.model.Auto;
import com.model.Manufacturer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.*;

public class AutoService {


    private static final Logger LOGGER = LoggerFactory.getLogger(AutoService.class);
    private static final Random RANDOM = new Random();
    private final AutoRepository autoRepository;


    public AutoService(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }


    public List<Auto> createAndSaveAutos(int count) {
        List<Auto> result = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            final Auto auto = new Auto(
                    "Model-" + RANDOM.nextInt(1000),
                    getRandomManufacturer(),
                    BigDecimal.valueOf(RANDOM.nextDouble(1000.0)),
                    "Model-" + RANDOM.nextInt(1000)
            );
            result.add(auto);
            LOGGER.debug("Created auto {}", auto.getId());
        }
        return result;
    }

    private Manufacturer getRandomManufacturer() {
        final Manufacturer[] values = Manufacturer.values();
        final int index = RANDOM.nextInt(values.length);
        return values[index];
    }

    public void saveAutos(List<Auto> autos) {
        autoRepository.create(autos);
    }

    public void printAll() {
        for (Auto auto : autoRepository.getAll()) {
            System.out.println(auto);
        }
    }
    public boolean update(Auto auto) {
        if (auto.getPrice().equals(BigDecimal.ZERO)) {
            auto.setPrice(BigDecimal.valueOf(-1));
        }
        if (auto.getManufacturer() == null) {
            throw new IllegalArgumentException();
        }
        if (auto.getBodyType().equals("")) {
            auto = autoRepository.findOneById(auto.getId()).orElseThrow(IllegalArgumentException::new);
        }
        return autoRepository.update(auto);
    }

        public List<Auto> getAll(){
            return autoRepository.getAll();
        }

        public Optional<Auto> findOneById(String id){
            return autoRepository.findOneById(id);
        }
        public void delete(String id){
            autoRepository.delete(id);
        }


    public Auto updateByBodyType() {
        return null;
    }
}

