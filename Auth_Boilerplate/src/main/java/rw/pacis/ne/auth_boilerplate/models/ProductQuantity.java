package rw.pacis.ne.auth_boilerplate.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_quantities")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ProductQuantity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String productCode;
    private int quantity;
    private String operation;
    @Column(updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @PrePersist
    public void prePersis(){
        date = new Date();
    }
}