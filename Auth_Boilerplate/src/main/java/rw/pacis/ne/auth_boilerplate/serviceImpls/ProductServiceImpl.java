package rw.pacis.ne.auth_boilerplate.serviceImpls;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import rw.pacis.ne.auth_boilerplate.dtos.CreateOrUpdateProductDTO;
import rw.pacis.ne.auth_boilerplate.dtos.ProductQuantityDTO;
import rw.pacis.ne.auth_boilerplate.exceptions.BadRequestException;
import rw.pacis.ne.auth_boilerplate.models.Product;
import rw.pacis.ne.auth_boilerplate.models.ProductQuantity;
import rw.pacis.ne.auth_boilerplate.repositories.IProductRepository;
import rw.pacis.ne.auth_boilerplate.services.IProductService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements IProductService {
    private final IProductRepository repository;

    public ProductServiceImpl(IProductRepository repository) {
        this.repository = repository;
    }

    public Product addNewProduct(CreateOrUpdateProductDTO dto){
        Optional<Product>  findByNameOrCode = repository.findByNameOrCode(dto.getName(), dto.getCode());
        if(findByNameOrCode.isPresent()) throw  new BadRequestException(String.format("Product with name '%s' and code '%s' already exists", dto.getName(), dto.getCode()));

        Product product = Product.builder()
                        .productType(dto.getProductType())
                                .price(dto.getPrice())
                                        .code(dto.getCode())
                                                .name(dto.getName())
                                                        .build();

        return repository.save(product);
    }

    public String uploadProductFile(MultipartFile file, UUID productId){
        try{
            String uploadsDir = "/home/mugisha/Documents/JavaProjects/NEPrep/JAVA/Auth_Boilerplate/uploads";
            Path filePath = Path.of(uploadsDir, file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            Optional<Product> product = repository.findProductById(productId);
            if(product.isPresent()){
                Product product1 = product.get();
                product1.setImage(filePath.toString());
                repository.save(product1);
            }else{
                throw  new BadRequestException(String.format("Product with id '%s' doen't exist", String.valueOf(productId)));
            }
        }catch(IOException e){
            // Handle the exception appropriately
            return "Failed to upload the file.";
        }
        return "File Uploaded Successfully";
    }



    @Override
    public List<Product> getAllProducts() {
        List<Product> products = repository.findAll();
        return products;
    }
}
