package com.repository;

import com.model.Motorbike;
import com.model.MotorbikeManufacturer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MotorbikeRepositoryTest {
    private MotorbikeRepository target;

    private Motorbike motorbike;

    @BeforeEach
    void setUp() {
        target = new MotorbikeRepository();
        motorbike = createMoto();
        target.save(motorbike);
    }

    private Motorbike createMoto() {
        return new Motorbike("Model", MotorbikeManufacturer.HONDA, BigDecimal.ZERO, "Type");
    }

    @Test
    void getById_findOne() {
        final Motorbike actual = target.getById(motorbike.getId());
        Assertions.assertNotNull(actual);
        assertEquals(motorbike.getId(), actual.getId());
    }

    @Test
    void getById_notFind() {
        final Motorbike actual = target.getById("1232");
        Assertions.assertNull(actual);
    }

    @Test
    void getById_findOne_manyAutos() {
        final Motorbike otherMotorbike = createMoto();
        target.save(otherMotorbike);
        final Motorbike actual = target.getById(motorbike.getId());
        Assertions.assertNotNull(actual);
        assertEquals(motorbike.getId(), actual.getId());
        Assertions.assertNotEquals(otherMotorbike.getId(), actual.getId());
    }

    @Test
    void getAll() {
        final List<Motorbike> actual = target.getAll();
        Assertions.assertNotNull(actual);
        assertEquals(1, actual.size());
    }

    @Test
    void save_success_notChangePrice() {
        motorbike.setPrice(BigDecimal.ONE);
        final boolean actual = target.save(motorbike);
        Assertions.assertTrue(actual);
        final Motorbike actualMotorbike = target.getById(motorbike.getId());
        assertEquals(BigDecimal.ONE, actualMotorbike.getPrice());
    }

    @Test
    void save_fail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> target.save(null));
    }

    @Test
    void save_success_changePrice() {
        target.save(motorbike);
        final Motorbike actual = target.getById(motorbike.getId());
        assertEquals(BigDecimal.valueOf(-1), actual.getPrice());
    }

    @Test
    void saveAll_null() {
        final boolean actual = target.saveAll(null);
        Assertions.assertFalse(actual);
    }

    @Test
    void saveAll_emptyList() {
        final boolean actual = target.saveAll(Collections.emptyList());
        Assertions.assertFalse(actual);
    }

    @Test
    void saveAll() {
        final boolean actual = target.saveAll(List.of(createMoto()));
        Assertions.assertTrue(actual);
    }

    @Test
    void update_notFound() {
        final Motorbike otherMotorbike = createMoto();
        final boolean actual = target.update(otherMotorbike);
        Assertions.assertFalse(actual);
    }

    @Test
    void update() {
        motorbike.setPrice(BigDecimal.TEN);
        final boolean actual = target.update(motorbike);
        Assertions.assertTrue(actual);
        final Motorbike actualMotorbike = target.getById(motorbike.getId());
        assertEquals(BigDecimal.TEN, actualMotorbike.getPrice());
    }



    @Test
    void delete() {
        target.save(motorbike);
        boolean actual = target.delete(motorbike.getId());
        Assertions.assertTrue(actual);
    }


}
