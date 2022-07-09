package src.main.java.com.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public abstract class MotorbikeVehicle {
    protected final String id;
    protected String model;
    protected BigDecimal price;
    protected MotorbikeManufacturer motorbikeManufacturer;

    protected MotorbikeVehicle(String model, MotorbikeManufacturer motorbikeManufacturer, BigDecimal price) {
        this.id = UUID.randomUUID().toString();
        this.model = model;
        this.motorbikeManufacturer = motorbikeManufacturer;
        this.price = price;
    }

}
