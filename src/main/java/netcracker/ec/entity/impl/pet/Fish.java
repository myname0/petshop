package netcracker.ec.entity.impl.pet;

import netcracker.ec.entity.Pet;
import netcracker.ec.entity.impl.AnimalImpl;
import netcracker.ec.service.GenerationService;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "fish")
public class Fish extends AnimalImpl implements Pet {

    public Fish() {
        GenerationService generator = new GenerationService();
        name = generator.generateName();
        breed = generator.generateFishBreed();
        character = generator.generateCharacter();
        cost = generator.generateCost();
        litteringDegree = 0;
    }

    public Fish(String name, String breed, Integer cost, String character) {
        super(name, breed, cost, character);

    }
}
