package my.home.forms;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import my.home.models.TypePack;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

@ApiModel(description = "form for create a new Office")
@Data

public class OfficeForm {

    @ApiModelProperty(value = "индекс нового офиса, который вы создаете, это 6-ти значное число", example = "153000")
    private Integer index;

    @ApiModelProperty(value = "кратное название нового офиса, который вы создаете", example = "Почта № 34")
    private String name;

    @ApiModelProperty(value = "полный адрес нового офиса, который вы создаете", example = "г. Новосибирск, ул. Пушкина, д.3, кв.1")
    private String address;



}
