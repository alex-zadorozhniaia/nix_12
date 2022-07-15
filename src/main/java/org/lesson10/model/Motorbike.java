package org.lesson10.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Motorbike extends Vehicle {
    private String bodyType;
    private final MotorbikeManufacturer manufacturer;

    public Motorbike(String model, MotorbikeManufacturer manufacturer, BigDecimal price, String bodyType) {
        super(model, count, price);
        this.manufacturer=manufacturer;
        this.bodyType = bodyType;
    }

    @Override
    public String toString() {
        return "Motorbike{" +
                "bodyType='" + bodyType + '\'' +
                ", id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", manufacturer=" + manufacturer +
                '}';
    }
}
