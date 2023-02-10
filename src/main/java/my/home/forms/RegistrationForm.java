package my.home.forms;

import lombok.Data;
import my.home.models.Office;
import my.home.models.TypePack;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

@Data
public class RegistrationForm {

    private Integer indexCurrentOffice;

    @Enumerated(value = EnumType.STRING)
    private TypePack type;

    private float weight;

    private float cost;

    private String name;

    private String address;

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
