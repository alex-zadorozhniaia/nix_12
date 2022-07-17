package com.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
public abstract class Vehicle {
    protected final String id;
    protected String model;
    protected int count;
    protected BigDecimal price;
    protected Manufacturer manufacturer;


    protected Vehicle(String model, BigDecimal price, MotorbikeManufacturer manufacturer) {
        this.id = UUID.randomUUID().toString();
        this.model = model;
        this.count = count;
        this.price = price;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,model,manufacturer,count,price);
    }
}
