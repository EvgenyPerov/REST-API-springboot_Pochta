package my.home.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@ApiModel(description = "data model of Status entity")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "statuses")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("id generation by DB auto")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @ApiModelProperty("вид статуса выбираем из списка (PROCESS, SEND, READY, COMPLETE)")
    private TypeStatus name;

    @ApiModelProperty("дата создания статуса генерируется автоматически  = текущей")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm z")
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pack")
    @ApiModelProperty("id посылки")
    private Pack pack;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_office")
    @ApiModelProperty("id текущего офиса в котором происходит изменение статуса посылки")
    private Office office;

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", name=" + name +
                ", date=" + date +
                ", pack=" + pack +
                ", office=" + office +
                '}';
    }
}
