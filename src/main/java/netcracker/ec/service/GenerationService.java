package netcracker.ec.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class GenerationService {
    private static final List<String> NAME = Arrays.asList("John", "Shaggy", "Blondie", "April", "Boomer",
            "Yeah Boy", "Bully", "Captain", "Chewy", "Cooper", "ITSY-BITSY", "Junior", "Leny", "Magic");
    private static final List<String> CHARACTER = Arrays.asList("pretty", "aggressive", "brave", "clever",
            "stupid", "affectionate", "neat");
    private static final List<String> FISH_BREED = Arrays.asList("cherry barb", "guppie", "neon tetra");
    private static final List<String> RABBIT_BREED = Arrays.asList("american fuzzy lop", "florida white",
            "holland lop", "harlequin");
    private static final List<String> KANGAROO_BREED = Arrays.asList("red", "eastern grey", "western grey");
    private static final List<String> MEERKAT_BREED = Arrays.asList("southern African", "angolan", "desert");

    private String generate(List<String> list) {
        int length = list.size();
        int randomInt = new Random().nextInt(length);
        return list.get(randomInt);
    }

    public String generateName() {
        return generate(NAME);
    }

    public String generateCharacter() {
        return generate(CHARACTER);
    }

    public String generateFishBreed() {
        return generate(FISH_BREED);
    }

    public String generateRabbitBreed() {
        return generate(RABBIT_BREED);
    }

    public String generateKangarooBreed() {
        return generate(KANGAROO_BREED);
    }

    public String generateMeerkatBreed() {
        return generate(MEERKAT_BREED);
    }

    public int generateCost() {
        return new Random().nextInt(100);
    }

    public int generateAge() {
        return new Random().nextInt(8);
    }

    public int generateWeight() {
        return new Random().nextInt(5000);
    }
}
