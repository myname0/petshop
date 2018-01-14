package netcracker.ec.service;

import netcracker.ec.entity.Animal;
import netcracker.ec.entity.impl.pet.Fish;
import netcracker.ec.entity.impl.pet.Rabbit;
import netcracker.ec.entity.impl.wildAnimal.Kangaroo;
import netcracker.ec.entity.impl.wildAnimal.Meerkat;
import netcracker.ec.service.impl.BuySellServiceImpl;
import netcracker.ec.storage.PetShopStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class RealLifeEmulator {

    //private PetShopStorage petShopStorage = new PetShopStorage();
    private PetShopStorage petShopStorage = PetShopStorage.getInstance();
    private BuySellService buySellService = new BuySellServiceImpl();

    private static final Logger LOG = LogManager.getLogger(RealLifeEmulator.class);

    public void live() {
        try {
            petShopStorage.getAnimalList();
            Thread dataThread = new Thread(new DataStoringService());
            Thread cleaningThread = new Thread(new CleaningJob());
            Thread litteringThread = new Thread(new LitteringJob());

            dataThread.start();
            cleaningThread.start();
            litteringThread.start();
            while (true) {
                int code = new Random().nextInt(10);
                switch (code) {
                    case 1:
                        buySellService.sell(getRandomAnimal());
                        break;
                    case 3:
                        buySellService.buy(createAnimal());
                        break;
                    case 8:
                        buySellService.buy(createAnimal());
                        break;
                    case 9:
                        runAway(getRandomAnimal());
                        break;
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Animal getRandomAnimal() {
        int length = petShopStorage.getAnimalList().size();
        if (length == 0) {
            return null;
        }
        int randInt = new Random().nextInt(length);
        return petShopStorage.getAnimalList().get(randInt);
    }

    private Animal createAnimal() {
        int type = new Random().nextInt(4);
        Animal animal = null;
        switch (type) {
            case 1:
                animal = new Fish();
                break;
            case 2:
                animal = new Rabbit();
                break;
            case 3:
                animal = new Kangaroo();
                break;
            case 0:
                animal = new Meerkat();
                break;
        }
        return animal;
    }

    private void runAway(Animal animal) {
        try {
            if (animal != null) {
                petShopStorage.deleteAnimal(animal);
                LOG.debug("run away: " + animal.toString());
                System.out.println("run away: " + animal.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
