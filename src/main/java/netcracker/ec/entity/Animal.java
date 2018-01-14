package netcracker.ec.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import netcracker.ec.entity.impl.pet.Fish;
import netcracker.ec.entity.impl.pet.Rabbit;
import netcracker.ec.entity.impl.wildAnimal.Kangaroo;
import netcracker.ec.entity.impl.wildAnimal.Meerkat;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Meerkat.class, name = "meerkat"),
        @JsonSubTypes.Type(value = Kangaroo.class, name = "kangaroo"),
        @JsonSubTypes.Type(value = Fish.class, name = "fish"),
        @JsonSubTypes.Type(value = Rabbit.class, name = "rabbit")
})
public interface Animal {
    String getBreed();

    String getName();

    Integer getCost();

    String getCharacter();

    Integer getLitteringDegree();

    void setLitteringDegree(Integer litterDegree);
}
