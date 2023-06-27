package rw.pacis.ne.auth_boilerplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rw.pacis.ne.auth_boilerplate.models.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IProductRepository extends JpaRepository<Product, UUID> {
    Optional<Product> findByNameOrCode(String name, String code);
    Optional<Product> findProductById(UUID id);

    Optional<Product> findByCode(String code);

    @Query("SELECT p FROM Product p")
    List<Product> findAll();

}
