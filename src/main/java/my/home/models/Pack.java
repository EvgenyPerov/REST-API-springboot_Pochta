package my.home.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@ApiModel(description = "data model of Pack entity")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "packs")
public class Pack implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("id generation by DB auto")
    private Long id;

    @Column(nullable = false)
    @ApiModelProperty("уникальный идентификатор генерирует программа автоматически")
    private String identifier;

    @Enumerated(value = EnumType.STRING)
    @ApiModelProperty("тип посылки выбираем из списка (PARCEL, LETTER, WRAPPER, POSTCARD)")
    @Column(name = "type_pack")
    private TypePack typePack;

    @ApiModelProperty(value = "вес посылки в КГ можно вводить не целое число" , example = "5.09")
    private Float weight;

    @ApiModelProperty(value = "стоимость посылки с учетом доставки можно вводить не целое число", example = "307.88")
    private Float cost;

    @Column(name = "index_destination")
    @ApiModelProperty(value = "индекс отделения получателя посылки", example = "153000")
    private int indexDestination;

    @Column(name = "address_destination")
    @ApiModelProperty(value = "адрес получателя посылки", example = "г. Новосибирск, ул. Пушкина, д.3, кв.1")
    private String addressDestination;

    @Column(name = "name_destination")
    @ApiModelProperty(value = "Имя получателя посылки", example = "Иванов Иван Иванович")
    private String nameDestination;

    @JsonIgnore
    @OneToMany(mappedBy= "pack", cascade = CascadeType.ALL)
    private List<Status> statusList;

    @Override
    public String toString() {
        return "Pack{" +
                "identifier='" + identifier + '\'' +
                ", typePack=" + typePack +
                ", weight=" + weight +
                ", cost=" + cost +
                ", indexDestination=" + indexDestination +
                ", addressDestination='" + addressDestination + '\'' +
                ", nameDestination='" + nameDestination + '\'' +
                '}';
    }
}
