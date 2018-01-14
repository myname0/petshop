package netcracker.ec.service.impl;

import netcracker.ec.entity.Animal;
import netcracker.ec.service.SearchService;
import netcracker.ec.storage.PetShopStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private PetShopStorage petShopStorage;

    public Animal findByName(String name) {
        Optional<Animal> animal = petShopStorage.getAnimalList()
                .stream()
                .filter(a -> a.getName().equals(name))
                .findFirst();

        return animal.get();
    }

    public Animal findByBreed(String breed) {
        Optional<Animal> animal = petShopStorage.getAnimalList()
                .stream()
                .filter(a -> a.getBreed().equals(breed))
                .findFirst();

        return animal.get();
    }

    public Animal findByCost(Integer cost) {
        Optional<Animal> animal = petShopStorage.getAnimalList()
                .stream()
                .filter(a -> a.getCost().equals(cost))
                .findFirst();

        return animal.get();
    }

    public Animal findByCharacter(String character) {
        Optional<Animal> animal = petShopStorage.getAnimalList()
                .stream()
                .filter(a -> a.getCharacter().equals(character))
                .findFirst();

        return animal.get();
    }
}
