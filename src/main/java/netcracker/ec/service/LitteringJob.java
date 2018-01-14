package netcracker.ec.service;

import netcracker.ec.entity.Animal;
import netcracker.ec.storage.PetShopStorage;

import java.util.List;


public class LitteringJob implements Runnable {
    private PetShopStorage petShopStorage = PetShopStorage.getInstance();
    private final int MIN = 20;
    private final int MAX = 30;

    @Override
    public void run() {
        try {
            while (true) {
                List<Animal> currentAnimals = petShopStorage.getAnimalList();
                for (Animal animal : currentAnimals) {
                    Integer randomDegree = MIN + (int) (Math.random() * MAX);
                    animal.setLitteringDegree(animal.getLitteringDegree() + randomDegree);
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
