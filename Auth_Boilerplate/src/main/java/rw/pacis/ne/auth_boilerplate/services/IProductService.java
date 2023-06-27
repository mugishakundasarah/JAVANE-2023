package rw.pacis.ne.auth_boilerplate.services;

import org.springframework.web.multipart.MultipartFile;
import rw.pacis.ne.auth_boilerplate.dtos.CreateOrUpdateProductDTO;
import rw.pacis.ne.auth_boilerplate.dtos.ProductQuantityDTO;
import rw.pacis.ne.auth_boilerplate.models.Product;

import java.util.List;
import java.util.UUID;

public interface IProductService {
    Product addNewProduct(CreateOrUpdateProductDTO dto);

    String uploadProductFile(MultipartFile file, UUID productId);



    List<Product> getAllProducts();
}
