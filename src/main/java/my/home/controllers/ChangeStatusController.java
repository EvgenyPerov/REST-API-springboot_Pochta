package my.home.controllers;

import my.home.forms.ChangeStatusForm;
import my.home.models.Status;
import my.home.models.TypeStatus;
import my.home.services.OfficeService;
import my.home.services.PackService;
import my.home.services.StatusTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Controller
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

    @GetMapping("/tracker")
    public String getStatus(ModelMap model) {
        model.addAttribute("types", Arrays.asList(TypeStatus.values()));
        model.addAttribute("findListByIdentifier",statuses);
        if (statuses.isEmpty()) {
            model.addAttribute("findedId","");
        } else {
                model.addAttribute("isCompleted",statusTrackService.isCompleted(statuses));
                model.addAttribute("findedId",statuses.get(0).getPack().getIdentifier());
                model.addAttribute("mapOffices",officeService.getMapOffices());
        }
        return "tracker";
    }

        @PostMapping("/tracker")
    public String changeStatus(ChangeStatusForm form){
            statuses = statusTrackService.findTracksByPackIdentifier(form.getIdentifier());
        return "redirect:/tracker";
    }


    @PostMapping("/tracker/add")
    public String addStatus(ChangeStatusForm form){
        packService.changeStatusOfTrack(form);
        return "redirect:/tracker";
    }

    @GetMapping("/packages")
    public String showPackages(ModelMap model) {
        model.addAttribute("mapOffices",officeService.getMapOffices());
        if (packages.isEmpty()) {
            model.addAttribute("indexAndAddress","");
        } else {
            model.addAttribute("indexAndAddress",
                    packages.get(0).getOffice().getIndex() + " " +packages.get(0).getOffice().getAddress());

            model.addAttribute("findPackagesByIndex",packages);
        }
//
        return "package";
    }

    @PostMapping("/packages")
    public String findPackages(ChangeStatusForm form){
        packages = statusTrackService.findTracksByPackIndexExclComplete(form.getIndex());
        return "redirect:/packages";
    }
}


