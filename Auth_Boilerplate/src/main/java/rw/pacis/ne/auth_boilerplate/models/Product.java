package rw.pacis.ne.auth_boilerplate.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "products")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true)
    private String code;
    @Column(unique = true)
    private String name;
    @Column
    private String productType;
    @Column
    private int price;

    @Column(updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inDate;
    @Column
    private String image;

    @OneToMany(mappedBy = "productCode", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ProductQuantity> quantities = new ArrayList<>();

    @PrePersist
    public void prePersist(){
        inDate = new Date();
    }

}
