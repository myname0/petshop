package netcracker.ec.controller;

import netcracker.ec.entity.Animal;
import netcracker.ec.storage.PetShopStorage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping(value = "/getallitems", method = RequestMethod.GET)
    public ResponseEntity<List<Animal>> getAllGoods() {
        PetShopStorage petShopStorage = PetShopStorage.getInstance();
        return new ResponseEntity<>(petShopStorage.getAnimalList(), HttpStatus.OK);
    }

    @RequestMapping(value = "/allitems")
    public ModelAndView getAllGoods(ModelAndView modelAndView){
        PetShopStorage petShopStorage = PetShopStorage.getInstance();
        modelAndView.setViewName("index");
        modelAndView.getModel().put("allitems", petShopStorage.getAnimalList());

        return modelAndView;
    }

    @RequestMapping("/home")
    ModelAndView home(ModelAndView modelAndView) {

        modelAndView.setViewName("home");
        modelAndView.getModel().put("name", "John");

        return modelAndView;
    }
}
