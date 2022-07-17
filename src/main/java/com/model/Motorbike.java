package com.model;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Type;
import java.math.BigDecimal;

@Getter
@Setter
public class Motorbike extends Vehicle {
    private Type bodyType;


    public Motorbike(String model, MotorbikeManufacturer manufacturer, BigDecimal price, Type bodyType) {
        super(model, price, manufacturer);
        this.bodyType = (Type) bodyType;
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
