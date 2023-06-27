package rw.pacis.ne.auth_boilerplate.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class CreateOrUpdateProductDTO {
    @NotBlank
    private String code;
    @NotBlank
    private String name;
    @NotBlank
    private String productType;
    @NotNull
    private int price;
}
