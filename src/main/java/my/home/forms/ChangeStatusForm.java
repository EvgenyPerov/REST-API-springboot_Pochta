package my.home.forms;

import lombok.Data;
import my.home.models.Office;
import my.home.models.TypePack;
import my.home.models.TypeStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

@Data
public class ChangeStatusForm {

    private String identifier;

    private Integer index;

    @Enumerated(value = EnumType.STRING)
    private TypeStatus typeStatus;

}
