package netcracker.ec;

import netcracker.ec.service.RealLifeEmulator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        //ApplicationContext context = new AnnotationConfigApplicationContext(PetShopConfig.class);
        SpringApplication.run(App.class, args);
        RealLifeEmulator emulator = new RealLifeEmulator();
        emulator.live();
    }
}
