package rw.pacis.ne.auth_boilerplate.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductQuantityDTO {
    private String productCode;
    private int quantity;
    private String operation;
}
