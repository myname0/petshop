package netcracker.ec.service.impl;

import netcracker.ec.service.RealLifeEmulator;
import netcracker.ec.entity.Animal;
import netcracker.ec.service.BuySellService;
import netcracker.ec.storage.PetShopStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class BuySellServiceImpl implements BuySellService {
    private static final Logger LOG = LogManager.getLogger(RealLifeEmulator.class);
//    private PetShopStorage petShopStorage = new PetShopStorage();
    private PetShopStorage petShopStorage = PetShopStorage.getInstance();


    public void buy(Animal animal) {
        petShopStorage.addAnimal(animal);
        LOG.debug("buy: " + animal.toString());
        System.out.println("buy: " + animal.toString());
    }

    public void sell(Animal animal) {
        try {
            if (animal != null) {
                petShopStorage.deleteAnimal(animal);
                System.out.println("sell: " + animal.toString());
                LOG.debug("sell: " + animal.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
