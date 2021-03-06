package netcracker.ec.service;

import netcracker.ec.entity.Animal;
import netcracker.ec.storage.PetShopStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CleaningJob implements Runnable {
    @Autowired
    private PetShopStorage petShopStorage;
    private final int MIN = 20;
    private final int MAX = 30;

    @Override
    public void run() {
        try {
            while (true) {
                List<Animal> currentAnimals = petShopStorage.getAnimalList();
                if(currentAnimals != null) {
                    for (Animal animal : currentAnimals) {
                        Integer randomDegree = MIN + (int) (Math.random() * MAX);
                        animal.setLitteringDegree(animal.getLitteringDegree() - randomDegree);
                    }
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
