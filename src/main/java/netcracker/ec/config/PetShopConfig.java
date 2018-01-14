package netcracker.ec.config;

import netcracker.ec.service.*;
import netcracker.ec.service.impl.BuySellServiceImpl;
import netcracker.ec.service.impl.SearchServiceImpl;
import netcracker.ec.storage.PetShopStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class PetShopConfig {
    @Bean
    BuySellService buySellService() {
        return new BuySellServiceImpl();
    }

    @Bean
    SearchService searchService() {
        return new SearchServiceImpl();
    }

    @Bean
    DataStoringService dataStoringService() {
        return new DataStoringService();
    }

    @Bean
    PetShopStorage petShopStorage() {
        return new PetShopStorage();
    }

    @Bean
    GenerationService generationService() {
        return new GenerationService();
    }

    @Bean
    RealLifeEmulator realLifeEmulator() {
        return new RealLifeEmulator();
    }

    @Bean
    PrintingService printingService(){
        return new PrintingService();
    }
}
