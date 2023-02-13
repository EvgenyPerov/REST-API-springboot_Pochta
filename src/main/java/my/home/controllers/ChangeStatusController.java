package my.home.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import my.home.forms.ChangeStatusForm;
import my.home.models.Status;
import my.home.services.OfficeService;
import my.home.services.PackService;
import my.home.services.StatusTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Api("class Get&Change_Statuses_Controller")
@RequestMapping("/api")
@RestController
public class ChangeStatusController {

    private StatusTrackService statusTrackService;
    private OfficeService officeService;

    private PackService packService;

    private List<Status> statuses = new ArrayList<>();
    private List<Status> packages = new ArrayList<>();

    @Autowired
    public ChangeStatusController(StatusTrackService statusTrackService, OfficeService officeService,PackService packService) {
        this.statusTrackService = statusTrackService;
        this.officeService = officeService;
        this.packService = packService;
    }

    @ApiOperation(value="Просмотр трекеров с посылками", notes="Посмотреть все трекеры в базе данных на основе объекта Status")
    @GetMapping(value = "/trackers", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Status> getStatus() {
        return statusTrackService.findAllTrackers();
    }

    @ApiOperation(value="обновить статус посылки", notes="Создать трекер с новым статусом на основе объекта Status. Вид статуса выбираем из списка (PROCESS, SEND, READY, COMPLETE)")
    @PostMapping("/trackers")
    public ResponseEntity<Status> changeStatus(ChangeStatusForm form){
        return ResponseEntity.ok(packService.changeStatusOfTrack(form));
    }

    @ApiOperation(value="Просмотр трекеров по посылке", notes="Посмотреть все трекеры для указанного идентификатора посылки на основе объекта Status")
    @GetMapping(value = "/trackers/findByIdentifier/{identifier}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Status> getStatusByIdentifier(@PathVariable String identifier) {
        return statusTrackService.findTracksByPackIdentifier(identifier);
    }

    @ApiOperation(value="Просмотр трекеров по текущему индексу", notes="Посмотреть все трекеры по индексу отделения, посылки которые нужно обработать этому отделению на основе объекта Status")
    @GetMapping(value = "/trackers/findByIndex/{index}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Status> getStatusByIdentifier(@PathVariable Integer index) {
        return statusTrackService.findTracksByPackIndexExclComplete(index);
    }
}


