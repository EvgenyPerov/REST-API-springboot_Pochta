package my.home.services;

import my.home.forms.ChangeStatusForm;
import my.home.forms.RegistrationForm;
import my.home.models.Office;
import my.home.models.Pack;
import my.home.models.TypeStatus;
import my.home.repositories.PackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PackService {

    private PackRepository repository;
    private StatusTrackService statusTrackService;

    private OfficeService officeService;

    @Autowired
    public PackService(PackRepository repository, StatusTrackService statusTrackService, OfficeService officeService) {
        this.repository = repository;
        this.statusTrackService = statusTrackService;
        this.officeService = officeService;
    }

    public String addPack(RegistrationForm form){
        String identifier = generateId(form);
        Pack pack = Pack.builder()
                .identifier(identifier)
                .typePack(form.getType())
                .weight(form.getWeight())
                .cost(form.getCost())
                .nameDestination(form.getName())
                .addressDestination(form.getAddress())
                .indexDestination(form.getIndex())
                .build();
        if (pack == null) return "";
        else {
            repository.save(pack);
            statusTrackService.addTrack(pack, officeService.getOfficeByIndex(form.getIndexCurrentOffice()), TypeStatus.PROCESS);
            return identifier;
        }
    }

    private String generateId(RegistrationForm form){

        String str = String.valueOf(form.hashCode());
        str = str.substring(1);
        str = str + new Date().getTime();

        List<Character> chars = str.chars()
                .mapToObj(e->(char)e).collect(Collectors.toList());

        Collections.shuffle(chars);

        String id = chars.stream()
                .map(e->e.toString())
                .collect(Collectors.joining());
        id = id.substring(0,4) + '-' + id.substring(4,8)  + '-' + id.substring(8,12);
    return "ID:" + id;
    }

    public Pack findOnePackByIdentificator(String ident){
        return repository.findPackByIdentifierIs(ident);
    }

    public boolean changeStatusOfTrack(ChangeStatusForm form){
        Pack pack = findOnePackByIdentificator(form.getIdentifier());
        Office office = officeService.getOfficeByIndex(form.getIndex());
        return statusTrackService.addTrack(pack, office, form.getTypeStatus());
    }
}
