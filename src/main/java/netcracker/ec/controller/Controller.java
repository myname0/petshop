package netcracker.ec.controller;

import netcracker.ec.entity.Animal;
import netcracker.ec.storage.PetShopStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    PetShopStorage petShopStorage;

    @RequestMapping(value = "/getallitems", method = RequestMethod.GET)
    public ResponseEntity<List<Animal>> getAllGoods() {
        return new ResponseEntity<>(petShopStorage.getAnimalList(), HttpStatus.OK);
    }

    @RequestMapping(value = "/allitems", method = RequestMethod.GET)
    public String getAllGoods(Model model) {
        model.addAttribute("allitems", petShopStorage.getAnimalList());
        return "allitems";
    }
}
