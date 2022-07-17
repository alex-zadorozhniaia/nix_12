package com.service;

import com.model.Motorbike;
import com.model.MotorbikeManufacturer;
import com.repository.MotorbikeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MotorbikeServiceTest {

    private MotorbikeService target;
    private MotorbikeRepository motorbikeRepository;

    @BeforeEach
    void setUp() {
        motorbikeRepository = Mockito.mock(MotorbikeRepository.class);
        target = new MotorbikeService(motorbikeRepository);
    }
    private  Motorbike createMoto() {
        return new  Motorbike("Model",  MotorbikeManufacturer.HONDA, BigDecimal.ZERO, "Type");
    }
    @Test
    void createAndSaveMotorbike_negative() {
        final List<Motorbike> actual = target.createMoto(-2);
        assertEquals(0, actual.size());
    }

    @Test
    void createAndSaveMotorbike_zero() {
        final List<Motorbike> actual = target.createMoto(0);
        assertEquals(0, actual.size());
    }

    @Test
    void createAndSaveMotorbike_positive() {
        final List<Motorbike> actual = target.createMoto(4);
        assertEquals(5, actual.size());
        Mockito.verify(motorbikeRepository, Mockito.times(4))
                .save(Mockito.any());
    }


    @Test
    void printAll() {
        List<Motorbike> moto = List.of(createMoto(), createMoto());
        Mockito.when(motorbikeRepository.getAll()).thenReturn(moto);
        target.printAll();
    }

    @Test
    void findOneById_null() {
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        target.findOneById(null);
        Mockito.verify(motorbikeRepository).findOneById(captor.capture());
        assertEquals("", captor.getValue());
    }


}