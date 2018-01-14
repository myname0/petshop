package netcracker.ec;

import netcracker.ec.config.PetShopConfig;
import netcracker.ec.service.RealLifeEmulator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(PetShopConfig.class);
        SpringApplication.run(App.class, args);
        RealLifeEmulator emulator = (RealLifeEmulator) context.getBean("realLifeEmulator");
        emulator.live();
    }
}
