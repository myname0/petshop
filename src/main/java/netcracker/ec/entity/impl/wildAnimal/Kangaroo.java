package netcracker.ec.entity.impl.wildAnimal;

import netcracker.ec.entity.WildAnimal;
import netcracker.ec.entity.impl.AnimalImpl;
import netcracker.ec.service.GenerationService;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Random;

//@XmlType(propOrder = {"child"})
@XmlRootElement(name = "kangaroo")
public class Kangaroo extends AnimalImpl implements WildAnimal {
    private Child child;

    //@XmlType(propOrder = {"age", "weight"})
    private class Child extends AnimalImpl { //mb public
        private Integer age;
        private Integer weight;

        public Child() {
            GenerationService generator = new GenerationService();
            this.name = generator.generateName();
            this.character = generator.generateCharacter();
            this.breed = Kangaroo.this.getBreed();
            this.cost = 0;
            this.age = generator.generateAge();
            this.weight = generator.generateWeight();
            this.litteringDegree = Kangaroo.this.getLitteringDegree();
        }

        public Child(String name, String breed, Integer cost, String character) {
            super(name, breed, cost, character);
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }
    }

    public Kangaroo() {
        GenerationService generator = new GenerationService();
        name = generator.generateName();
        breed = generator.generateKangarooBreed();
        character = generator.generateCharacter();
        cost = generator.generateCost();
        if (new Random().nextInt(1) == 1) {
            child = new Child();
        }
        litteringDegree = 0;
    }

    public Kangaroo(String name, String breed, Integer cost, String character) {
        super(name, breed, cost, character);
    }

    public Kangaroo(String name, String breed, Integer cost, String character, Integer age, Integer weight) {
        super(name, breed, cost, character);

        child = new Child(name, breed, cost, character);
        child.setAge(age);
        child.setWeight(weight);
    }

    public Child getChild() {
        return child;
    }
}
