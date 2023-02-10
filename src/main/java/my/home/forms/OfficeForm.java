package my.home.forms;

import lombok.Data;
import my.home.models.TypePack;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

@Data
public class OfficeForm {

    private Integer index;

    private String name;

    private String address;



}
