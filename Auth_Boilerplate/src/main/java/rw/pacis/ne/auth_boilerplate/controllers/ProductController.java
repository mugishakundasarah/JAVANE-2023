package rw.pacis.ne.auth_boilerplate.controllers;

import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rw.pacis.ne.auth_boilerplate.dtos.CreateOrUpdateProductDTO;
import rw.pacis.ne.auth_boilerplate.payload.ApiResponse;
import rw.pacis.ne.auth_boilerplate.services.IProductService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final IProductService service;
    public  ProductController(IProductService service){
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody CreateOrUpdateProductDTO dto){
        return ResponseEntity.ok(ApiResponse.success(this.service.addNewProduct(dto)));
    }



    @PostMapping("/product-image")
    public ResponseEntity<ApiResponse> uploadImage(
            @RequestParam("productId") UUID productId,
            @RequestParam("file")MultipartFile file) throws IOException {
        return ResponseEntity.ok(ApiResponse.success(this.service.uploadProductFile(file, productId)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getProducts(){
        return ResponseEntity.ok(ApiResponse.success(this.service.getAllProducts()));
    }
}
