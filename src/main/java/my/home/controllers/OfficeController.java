package my.home.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import my.home.forms.OfficeForm;
import my.home.models.Office;
import my.home.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Api("class Office_Controller")
@RequestMapping("/api")
public class OfficeController {

    private OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @ApiOperation(value="Просмотр офисов", notes="Посмотреть все офисы на основе объекта Office")
    @GetMapping(value = "/offices", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Office>> getOffice() {
        List<Office> list = officeService.getAllOffices();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @ApiOperation(value="Просмотр офиса", notes="Посмотреть офис по индексу на основе объекта Office")
    @GetMapping(value = "/offices/{index}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

    public ResponseEntity<Office> getOfficeByIndex(@PathVariable Integer index) {
        return ResponseEntity.ok(officeService.getOfficeByIndex(index));
    }

    @ApiOperation(value="Создать офис", notes="Создать офис на основе объекта Office")
    @PostMapping("/offices")
    public ResponseEntity<Office> setOffice(OfficeForm form) {
        return ResponseEntity.ok(officeService.addOffice(form));
    }
}


