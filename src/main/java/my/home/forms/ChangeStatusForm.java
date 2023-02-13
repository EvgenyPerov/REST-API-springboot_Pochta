package my.home.forms;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import my.home.models.Office;
import my.home.models.TypePack;
import my.home.models.TypeStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

@Data
@ApiModel(description = "form for change of Status")
public class ChangeStatusForm {

    @ApiModelProperty(value = "идентификатор посылки,у которой будет меняться статус", example = "ID:7769-6753-0061")
    private String identifier;

    @ApiModelProperty(value = "индекс вашего офиса, в котором происходит изменение статуса посылки", example = "105275")
    private Integer index;

    @ApiModelProperty("вид статуса выбираем из списка")
    @Enumerated(value = EnumType.STRING)
    private TypeStatus typeStatus;

}
