package src.main.java.com;

import src.main.java.com.model.Auto;
import src.main.java.com.model.Motorbike;
import src.main.java.com.service.AutoService;
import src.main.java.com.service.MotorbikeService;

import java.util.List;

public class Main {
    private static final AutoService AUTO_SERVICE = new AutoService();
    private static final MotorbikeService MOTORBIKE_SERVICE = new MotorbikeService();

    public static void main(String[] args) {
        final List<Auto> autos = AUTO_SERVICE.createAutos(10);
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