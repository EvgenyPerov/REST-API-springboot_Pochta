package my.home.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import my.home.forms.RegistrationForm;
import my.home.models.Pack;
import my.home.models.TypePack;
import my.home.services.OfficeService;
import my.home.services.PackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Api("class Pack_Registration_Controller")
@RequestMapping("/api")
@RestController
public class RegistrationController {
    private String identifier = "";
    private PackService packService;
    private OfficeService officeService;

    @Autowired
    public RegistrationController(PackService packService, OfficeService officeService) {
        this.packService = packService;
        this.officeService = officeService;
    }

    @ApiOperation(value="Просмотр посылок", notes="Посмотреть все посылки на основе объекта Pack")
    @GetMapping(value = "/registrations",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Pack> getPackRegistration() {
        return packService.findAllPacks();
    }

    @ApiOperation(value="Просмотр посылки", notes="Посмотреть посылку по идентификатору на основе объекта Pack")
    @GetMapping(value = "/registrations/{identifier}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Pack getPackRegistrationByIdentifier(@PathVariable String identifier) {
        return packService.findOnePackByIdentificator(identifier);
    }

    @ApiOperation(value="Создать посылку", notes="Создать посылку на основе объекта RegistrationForm. Тип посылки выбираем из списка (PARCEL, LETTER, WRAPPER, POSTCARD)")
    @PostMapping("/registrations")
    public Pack setPackRegistration(RegistrationForm form){
        return packService.addPack(form);
    }

  }


