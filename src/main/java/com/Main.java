package com;


import com.repository.AutoRepository;
import com.repository.MotorbikeRepository;
import com.service.MotorbikeService;
import com.model.Auto;
import com.model.Motorbike;
import com.service.AutoService;

import java.util.List;
import java.util.Optional;

public class Main {
    private static final AutoService AUTO_SERVICE = new AutoService(new AutoRepository());

    private static final MotorbikeService MOTORBIKE_SERVICE = new MotorbikeService(new MotorbikeRepository());

    public static void main(String[] args) {
        final List<Auto> autos = AUTO_SERVICE.createAndSaveAutos(10);
        AUTO_SERVICE.saveAutos(autos);
        AUTO_SERVICE.printAll();
        Auto auto = AUTO_SERVICE.getAll().get(3);
        AUTO_SERVICE.update(auto);
        AUTO_SERVICE.delete(auto.getId());
        AUTO_SERVICE.printAll();


        final List<Motorbike> moto = MOTORBIKE_SERVICE.createMoto(3);
        MOTORBIKE_SERVICE.saveMoto(moto);
        MOTORBIKE_SERVICE.printAll();
        Motorbike motorbike = MOTORBIKE_SERVICE.getAll().get(2);
        MOTORBIKE_SERVICE.update(motorbike);
        MOTORBIKE_SERVICE.delete(motorbike.getId());
        MOTORBIKE_SERVICE.printAll();
    }
}