package my.home.forms;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import my.home.models.Office;
import my.home.models.TypePack;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

@ApiModel(description = "form for create a new Pack")
@Data
public class RegistrationForm {

    @ApiModelProperty(value = "индекс вашего офиса, в котором регистрируется посылка, это 6-ти значное число", example = "153000")
    private Integer indexCurrentOffice;

    @ApiModelProperty("тип посылки выбираем из списка: PARCEL-Посылка, LETTER-Письмо, WRAPPER-Бандероль, POSTCARD-Открытка")
    @Enumerated(value = EnumType.STRING)
    private TypePack type;

    @ApiModelProperty(value = "вес посылки в КГ можно вводить не целое число" , example = "5.09")
    private float weight;

    @ApiModelProperty(value = "стоимость посылки с учетом доставки можно вводить не целое число", example = "307.88")
    private float cost;

    @ApiModelProperty(value = "Имя получателя посылки", example = "Иванов Иван Иванович")
    private String name;

    @ApiModelProperty(value = "адрес получателя посылки", example = "г. Новосибирск, ул. Пушкина, д.3, кв.1")
    private String address;

    @ApiModelProperty(value = "индекс отделения получателя посылки", example = "153000")
    private Integer index;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationForm that = (RegistrationForm) o;
        return Float.compare(that.weight, weight) == 0
                && Float.compare(that.cost, cost) == 0
                && type == that.type
                && Objects.equals(name, that.name)
                && Objects.equals(address, that.address)
                && Objects.equals(index, that.index);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = (int) (prime * result + weight);
        result = (int) (prime * result + cost);
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((index == null) ? 0 : index.hashCode());
        return result;
    }


}
