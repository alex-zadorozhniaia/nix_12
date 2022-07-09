package src.main.java.com.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Motorbike extends MotorbikeVehicle {
    private String bodyType;

    public Motorbike(String model, MotorbikeManufacturer motorbikeManufacturer, BigDecimal price, String bodyType) {
        super(model, motorbikeManufacturer, price);
        this.bodyType = bodyType;
    }

    @Override
    public String toString() {
        return "Motorbike{" +
                "bodyType='" + bodyType + '\'' +
                ", id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", manufacturer=" + motorbikeManufacturer +
                '}';
    }
}
