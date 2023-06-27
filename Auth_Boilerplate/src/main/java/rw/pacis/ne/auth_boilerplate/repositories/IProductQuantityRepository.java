package rw.pacis.ne.auth_boilerplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.pacis.ne.auth_boilerplate.models.ProductQuantity;

import java.util.UUID;

public interface IProductQuantityRepository extends JpaRepository<ProductQuantity, UUID> {

}
