package src.main.java.com.service;

import src.main.java.com.model.Auto;
import src.main.java.com.model.Manufacturer;
import src.main.java.com.repository.AutoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.*;

public class AutoService {


    private static final Logger LOGGER = LoggerFactory.getLogger(AutoService.class);
    private static final Random RANDOM = new Random();
    private static final AutoRepository AUTO_REPOSITORY = new AutoRepository();



    public List<Auto> createAutos(int count) {
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
        AUTO_REPOSITORY.create(autos);
    }

    public void printAll() {
        for (Auto auto : AUTO_REPOSITORY.getAll()) {
            System.out.println(auto);
        }
    }
        public void update(Auto auto){ AUTO_REPOSITORY.update(auto);}

        public List<Auto> getAll(){
            return AUTO_REPOSITORY.getAll();
        }

        public Optional<Auto> findId(String id){
            return AUTO_REPOSITORY.findId(id);
        }
        public void delete(String id){
            AUTO_REPOSITORY.delete(id);
        }


}

