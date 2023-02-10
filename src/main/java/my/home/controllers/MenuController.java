package my.home.controllers;

import my.home.forms.OfficeForm;
import my.home.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MenuController {

    @GetMapping("/menu")
    public String getMenu() {
        return "menu";
    }

}


