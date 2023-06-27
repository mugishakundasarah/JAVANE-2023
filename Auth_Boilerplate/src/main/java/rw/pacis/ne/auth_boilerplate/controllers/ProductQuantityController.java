package rw.pacis.ne.auth_boilerplate.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.pacis.ne.auth_boilerplate.dtos.ProductQuantityDTO;
import rw.pacis.ne.auth_boilerplate.payload.ApiResponse;
import rw.pacis.ne.auth_boilerplate.services.IProductQuantityService;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/product-quantity")
public class ProductQuantityController {
    private final IProductQuantityService service;

    public ProductQuantityController(IProductQuantityService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> updateProductQuantity(
            @Valid @RequestBody ProductQuantityDTO productQuantityDTO
    ) {
        return ResponseEntity.ok(ApiResponse.success(service.registerProductQuantity(productQuantityDTO)));
    }
}
