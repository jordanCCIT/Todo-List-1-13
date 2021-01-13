package com.example.demo.controllers;
import com.example.demo.storage.OwnerStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class OwnerController {
    OwnerStorage ownerStorage;

    public OwnerController(OwnerStorage inOwnerStorage){
        ownerStorage = inOwnerStorage;
    }

    @RequestMapping({"","/"})
    public String displayHomePage(Model model){
        model.addAttribute("owners",ownerStorage.retrieveAllOwners());
        return "homepage-temp";
    }

    @RequestMapping("owner/{id}")
    public String displaySingleOwner(Model model, @PathVariable Long id){
        model.addAttribute("owner",ownerStorage.retrieveOwnerById(id));
        return "users";
    }
}
