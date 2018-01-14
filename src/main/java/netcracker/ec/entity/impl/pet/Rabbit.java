package netcracker.ec.entity.impl.pet;

import netcracker.ec.entity.Pet;
import netcracker.ec.entity.impl.AnimalImpl;
import netcracker.ec.service.GenerationService;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rabbit")
public class Rabbit extends AnimalImpl implements Pet {
    public Rabbit() {
        GenerationService generator = new GenerationService();
        name = generator.generateName();
        breed = generator.generateRabbitBreed();
        character = generator.generateCharacter();
        cost = generator.generateCost();
        litteringDegree = 0;
    }

    public Rabbit(String name, String breed, Integer cost, String character) {
        super(name, breed, cost, character);
    }
}
