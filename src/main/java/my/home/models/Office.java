package my.home.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@ApiModel(description = "data model of Office entity")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "offices")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("id generation by DB auto")
    private int id;

    @Column(name = "index_office")
    @ApiModelProperty(value = "индекс отделения", example = "153000")
    private int index;

    @Column(name = "name_office")
    @ApiModelProperty(value = "название отделения", example = "Почта № 34")
    private String name;

    @Column(name = "address_office")
    @ApiModelProperty(value = "адрес отделения", example = "г. Новосибирск, ул. Пушкина, д.3, кв.1")
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy= "office", cascade = CascadeType.ALL)
    private List<Status> statusList;

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", index=" + index +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
