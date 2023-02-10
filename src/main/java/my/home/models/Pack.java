package my.home.models;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "packs")
public class Pack implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String identifier;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "type_pack")
    private TypePack typePack;

    private Float weight;

    private Float cost;

    @Column(name = "index_destination")
    private int indexDestination;

    @Column(name = "address_destination")
    private String addressDestination;

    @Column(name = "name_destination")
    private String nameDestination;

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
