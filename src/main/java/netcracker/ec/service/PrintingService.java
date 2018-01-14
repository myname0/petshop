package netcracker.ec.service;

import org.springframework.stereotype.Service;

@Service
public class PrintingService {

    public void print(String message){
        System.out.println(message);
    }
}
