package netcracker.ec.service;

import netcracker.ec.entity.Animal;

public interface BuySellService {
    /**
     *Buy animal.
     * @param animal - animal, that should be purchased.
     */
    void buy(Animal animal);

    /**
     * Sell animal.
     * @param animal - animal, that should be sold.
     */
    void sell(Animal animal);
}
