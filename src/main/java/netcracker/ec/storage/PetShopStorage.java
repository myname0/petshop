package netcracker.ec.storage;

import netcracker.ec.entity.Animal;
import netcracker.ec.entity.impl.pet.Fish;
import netcracker.ec.entity.impl.pet.Rabbit;
import netcracker.ec.entity.impl.wildAnimal.Kangaroo;
import netcracker.ec.entity.impl.wildAnimal.Meerkat;
import netcracker.ec.service.DataStoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.*;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Component
public class PetShopStorage {
    @XmlElementWrapper(name = "animals")
    @XmlElements({
            @XmlElement(name = "fish", type = Fish.class),
            @XmlElement(name = "rabbit", type = Rabbit.class),
            @XmlElement(name = "kangaroo", type = Kangaroo.class),
            @XmlElement(name = "meerkat", type = Meerkat.class)
    })
    private List<Animal> animalList = new LinkedList<>();

    @Autowired
    DataStoringService dataStoringService;

    public PetShopStorage() {
    }

    public List<Animal> getAnimalList() {
        if (animalList == null) {
            animalList = new LinkedList<>(dataStoringService.load());
        }
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }

    public void deleteAnimal(Animal animal) throws Exception {
        if (animalList.contains(animal)) {
            animalList.remove(animal);
        } else {
            throw new Exception("There is no Animal" + animal.toString() + "in the shop");
        }
    }
}
