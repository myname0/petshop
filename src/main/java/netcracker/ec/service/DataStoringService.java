package netcracker.ec.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import netcracker.ec.entity.impl.pet.Fish;
import netcracker.ec.entity.impl.pet.Rabbit;
import netcracker.ec.entity.impl.wildAnimal.Kangaroo;
import netcracker.ec.entity.impl.wildAnimal.Meerkat;
import netcracker.ec.storage.PetShopStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class DataStoringService implements Runnable {

    //private PetShopStorage petShopStorage = new PetShopStorage();
    @Autowired
    private PetShopStorage petShopStorage = new PetShopStorage();
//    private PetShopStorage petShopStorage = PetShopStorage.getInstance();

    private void saveToJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
//        List<Animal> animals = petShopStorage.getAnimalList();

        try (FileOutputStream outputStream = new FileOutputStream("src/main/resources/data.json")) {

//                objectMapper.writeValue(outputStream, animals);
            objectMapper.writeValue(outputStream, petShopStorage);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void saveToXML(){
        try {
            JAXBContext context = JAXBContext.newInstance(PetShopStorage.class, Fish.class, Rabbit.class, Meerkat.class, Kangaroo.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            try (FileOutputStream outputStream = new FileOutputStream("src/main/resources/data.xml")) {
                marshaller.marshal(petShopStorage, outputStream);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }

    public void run() {
        try {
            while (true) {
                saveToJSON();
                saveToXML();
                Thread.sleep(10000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
