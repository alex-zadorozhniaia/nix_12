package com.service;

import com.model.Auto;
import com.model.Manufacturer;
import com.repository.AutoRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;



class AutoServiceTest {

    private AutoService target;
    private AutoRepository autoRepository;

    @BeforeEach
    void setUp() {
        autoRepository = Mockito.mock(AutoRepository.class);
        target = new AutoService(autoRepository);
    }
    private Auto createSimpleAuto() {
        return new Auto("Model", Manufacturer.BMW, BigDecimal.ZERO, "Type");
    }
    @Test
    void createAndSaveAutos_negative() {
        final List<Auto> actual = target.createAndSaveAutos(-2);
        assertEquals(0, actual.size());
    }

    @Test
    void createAndSaveAutos_zero() {
        final List<Auto> actual = target.createAndSaveAutos(0);
        assertEquals(0, actual.size());
    }

    @Test
    void createAndSaveAutos_positive() {
        final List<Auto> actual = target.createAndSaveAutos(4);
        assertEquals(5, actual.size());
        Mockito.verify(autoRepository, Mockito.times(4))
                .save(Mockito.any());
    }


    @Test
    void printAll() {
        List<Auto> autos = List.of(createSimpleAuto(), createSimpleAuto());
        Mockito.when(autoRepository.getAll()).thenReturn(autos);
        target.printAll();
    }

    @Test
    void findOneById_null() {
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        target.findOneById(null);
        Mockito.verify(autoRepository).getById(captor.capture());
        assertEquals("", captor.getValue());
    }


}