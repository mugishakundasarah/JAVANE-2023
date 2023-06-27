package rw.pacis.ne.auth_boilerplate.models;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "purchased")
public class Purchased {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "product_code")
    private String productCode;

    private int quantity;

    private double total;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;


    @PrePersist
    public void prePersist(){
        date = new Date();
    }
}
