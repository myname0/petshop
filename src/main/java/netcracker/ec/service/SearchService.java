package netcracker.ec.service;

import netcracker.ec.entity.Animal;


public interface SearchService {
    /**
     * Find animal by name.
     * @param name This the name on which animal will be found.
     * @return founded animal.
     */
    Animal findByName(String name);

    /**
     * Find animal by breed.
     * @param breed This the breed on which animal will be found.
     * @return founded animal.
     */
    Animal findByBreed(String breed);

    /**
     * Find animal by cost.
     * @param cost This the cost on which animal will be found.
     * @return founded animal.
     */
    Animal findByCost(Integer cost);

    /**
     * Find animal by character.
     * @param character This the character on which animal will be found.
     * @return founded animal.
     */
    Animal findByCharacter(String character);
}
