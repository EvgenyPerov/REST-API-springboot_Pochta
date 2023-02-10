package my.home.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "offices")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "index_office")
    private int index;

    @Column(name = "name_office")
    private String name;

    @Column(name = "address_office")
    private String address;

    @OneToMany(mappedBy= "office", cascade = CascadeType.ALL)
    private List<Status> statusList;

    @Override
    public String toString() {
        return "Office{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
