package org.lesson10.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public abstract class Vehicle {
    protected final String id;
    protected String model;
    protected int count;
    protected BigDecimal price;


    protected Vehicle(String model, int count, BigDecimal price) {
        this.id = UUID.randomUUID().toString();
        this.model = model;
        this.count = count;
        this.price = price;
    }

}
