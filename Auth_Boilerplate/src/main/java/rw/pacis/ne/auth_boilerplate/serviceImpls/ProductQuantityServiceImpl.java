package rw.pacis.ne.auth_boilerplate.serviceImpls;

import org.springframework.stereotype.Service;
import rw.pacis.ne.auth_boilerplate.dtos.ProductQuantityDTO;
import rw.pacis.ne.auth_boilerplate.exceptions.BadRequestException;
import rw.pacis.ne.auth_boilerplate.models.Product;
import rw.pacis.ne.auth_boilerplate.models.ProductQuantity;
import rw.pacis.ne.auth_boilerplate.repositories.IProductQuantityRepository;
import rw.pacis.ne.auth_boilerplate.repositories.IProductRepository;
import rw.pacis.ne.auth_boilerplate.services.IProductQuantityService;

import java.util.Optional;

@Service
public class ProductQuantityServiceImpl implements IProductQuantityService {
    private final IProductQuantityRepository repository;

    private final IProductRepository productRepository;

    public ProductQuantityServiceImpl(IProductQuantityRepository repository, IProductRepository productRepository) {
        this.repository = repository;
        this.productRepository = productRepository;
    }


    public String registerProductQuantity(ProductQuantityDTO productQuantityDTO) {
        Optional<Product> optionalProduct = productRepository.findByCode(productQuantityDTO.getProductCode());
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            ProductQuantity productQuantity = ProductQuantity.builder()
                    .productCode(productQuantityDTO.getProductCode())
                    .quantity(productQuantityDTO.getQuantity())
                    .operation(productQuantityDTO.getOperation())
                    .build();
            repository.save(productQuantity);
        } else {
            throw  new BadRequestException(String.format("Product with code '%s' doen't exist", String.valueOf(productQuantityDTO.getProductCode())));
        }

        return "Quantity added successfully";
    }
}
