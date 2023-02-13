package my.home.services;

import my.home.forms.OfficeForm;
import my.home.models.Office;
import my.home.repositories.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class OfficeService {

    private OfficeRepository repository;

    @Autowired
    public OfficeService(OfficeRepository repository) {
        this.repository = repository;
    }

    public Office addOffice(OfficeForm form){
        Office office = Office.builder()
                .index(form.getIndex())
                .name(form.getName())
                .address(form.getAddress())
                .build();
        if (office != null)
            repository.save(office);
            return office;
    }

    public List<Office> getAllOffices(){
        return repository.findAll();
    }

    public Office getOfficeByIndex(Integer index){
        return repository.findFirstByIndexIs(index);
    }

}
