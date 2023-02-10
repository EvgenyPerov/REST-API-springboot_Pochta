package my.home.services;

import my.home.forms.OfficeForm;
import my.home.forms.RegistrationForm;
import my.home.models.Office;
import my.home.models.Pack;
import my.home.repositories.OfficeRepository;
import my.home.repositories.PackRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OfficeService {

    private OfficeRepository repository;

    @Autowired
    public OfficeService(OfficeRepository repository) {
        this.repository = repository;
    }

    public boolean addOffice(OfficeForm form){
        Office office = Office.builder()
                .index(form.getIndex())
                .name(form.getName())
                .address(form.getAddress())
                .build();
        if (office == null) return false;
        else {
            repository.save(office);
            return true;
        }
    }

    public List<Office> getAllOffices(){
        return repository.findAll();
    }

    public Office getOfficeByIndex(Integer index){
        return repository.findFirstByIndexIs(index);
    }

    public Map<Integer, String> getMapOffices(){
        Map<Integer, String> map = new TreeMap<>();
        List<Office> list = getAllOffices();
        list.forEach(o -> { map.put(o.getIndex(), o.getAddress());  });
        return map;
    }

}
