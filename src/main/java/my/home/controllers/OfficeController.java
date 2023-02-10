package my.home.controllers;

import my.home.forms.OfficeForm;
import my.home.forms.RegistrationForm;
import my.home.models.TypePack;
import my.home.services.OfficeService;
import my.home.services.PackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
public class OfficeController {

    private OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }



    @GetMapping("/offices")
    public String getRegistration(ModelMap model) {
        model.addAttribute("listOffices", officeService.getAllOffices());
        return "office";
    }

    @PostMapping("/offices")
    public String setOffice(OfficeForm form){
        officeService.addOffice(form);
        return "redirect:/offices";
    }
}


