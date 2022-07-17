package com.model;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Type;
import java.math.BigDecimal;

@Getter
@Setter
public class Motorbike extends Vehicle {
    private String bodyType;


    public Motorbike(String model, MotorbikeManufacturer manufacturer, BigDecimal price, String bodyType) {
        super(model, price, manufacturer);
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
