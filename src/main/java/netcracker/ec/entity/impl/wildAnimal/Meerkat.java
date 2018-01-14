package netcracker.ec.entity.impl.wildAnimal;

import netcracker.ec.entity.WildAnimal;
import netcracker.ec.entity.impl.AnimalImpl;
import netcracker.ec.service.GenerationService;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "meerkat")
public class Meerkat extends AnimalImpl implements WildAnimal {
    public Meerkat() {
        GenerationService generator = new GenerationService();
        name = generator.generateName();
        breed = generator.generateMeerkatBreed();
        character = generator.generateCharacter();
        cost = generator.generateCost();
        litteringDegree = 0;
    }

    public Meerkat(String name, String breed, Integer cost, String character) {
        super(name, breed, cost, character);
    }
}
