package netcracker.ec.service.impl;

import netcracker.ec.entity.Animal;
import netcracker.ec.service.BuySellService;
import netcracker.ec.service.PrintingService;
import netcracker.ec.service.RealLifeEmulator;
import netcracker.ec.storage.PetShopStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@ComponentScan
public class BuySellServiceImpl implements BuySellService {
    private static final Logger LOG = LogManager.getLogger(RealLifeEmulator.class);
    @Autowired
    private PetShopStorage petShopStorage;
    @Autowired
    private PrintingService printingService;


    public void buy(Animal animal) {
        petShopStorage.addAnimal(animal);
        LOG.debug("buy: " + animal.toString());
        printingService.print("buy: " + animal.toString());
    }

    public void sell(Animal animal) {
        try {
            if (animal != null) {
                petShopStorage.deleteAnimal(animal);
                printingService.print("sell: " + animal.toString());
                LOG.debug("sell: " + animal.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
