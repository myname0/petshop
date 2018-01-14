package netcracker.ec.entity.impl;

import netcracker.ec.entity.Animal;


public abstract class AnimalImpl implements Animal {
    protected String name;
    protected String breed;
    protected Integer cost;
    protected String character;
    protected Integer litteringDegree;

    public AnimalImpl() {
    }

    public AnimalImpl(String name, String breed, Integer cost, String character) {
        this.name = name;
        this.breed = breed;
        this.cost = cost;
        this.character = character;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public Integer getLitteringDegree() {
        return litteringDegree;
    }

    public void setLitteringDegree(Integer litteringDegree) {
        if (litteringDegree < 0) {
            this.litteringDegree = 0;
        } else if (litteringDegree > 100) {
            this.litteringDegree = 100;
        } else {
            this.litteringDegree = litteringDegree;
        }
    }

    @Override
    public String toString() {
        return "AnimalImpl{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", litteringDegree='" + litteringDegree + '\'' +
                '}';
    }
}
