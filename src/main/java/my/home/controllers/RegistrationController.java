package my.home.controllers;

import my.home.forms.RegistrationForm;
import my.home.models.TypePack;
import my.home.services.OfficeService;
import my.home.services.PackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;

@Controller
public class RegistrationController {
    private String identifier = "";
    private PackService packService;
    private OfficeService officeService;

    @Autowired
    public RegistrationController(PackService packService, OfficeService officeService) {
        this.packService = packService;
        this.officeService = officeService;
    }

    @GetMapping("/registration")
    public String getRegistration(ModelMap model) {
        model.addAttribute("types", Arrays.asList(TypePack.values()));
        model.addAttribute("offices", officeService.getAllOffices());
        model.addAttribute("mapOffices",officeService.getMapOffices());
        model.addAttribute("newID",identifier);
        return "registration";
    }

    @PostMapping("/registration")
    public String setRegistration(RegistrationForm form, ModelMap model){
        identifier = packService.addPack(form);
        model.addAttribute("newID", identifier);
        return "/showRegistration";
    }

  }


