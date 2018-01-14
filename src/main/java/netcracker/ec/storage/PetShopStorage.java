package netcracker.ec.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import netcracker.ec.entity.Animal;
import netcracker.ec.entity.impl.pet.Fish;
import netcracker.ec.entity.impl.pet.Rabbit;
import netcracker.ec.entity.impl.wildAnimal.Kangaroo;
import netcracker.ec.entity.impl.wildAnimal.Meerkat;

import javax.xml.bind.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PetShopStorage {
    private final static PetShopStorage INSTANCE = new PetShopStorage();
    @XmlElementWrapper(name = "animals")
    @XmlElements({
            @XmlElement(name = "fish", type = Fish.class),
            @XmlElement(name = "rabbit", type = Rabbit.class),
            @XmlElement(name = "kangaroo", type = Kangaroo.class),
            @XmlElement(name = "meerkat", type = Meerkat.class)
    })
    private List<Animal> animalList;

//    public PetShopStorage() {
//    }
    private PetShopStorage(){
    }

    public static PetShopStorage getInstance() {
        return INSTANCE;
    }

    public List<Animal> getAnimalList() {
        if (animalList == null) {
            ObjectMapper mapper = new ObjectMapper();
            try (FileInputStream outputStream = new FileInputStream("src/anData.json")) {
                PetShopStorage petShopStorage = mapper.readValue(outputStream, PetShopStorage.class);
                animalList = new LinkedList<Animal>(petShopStorage.getAnimalList());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
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
