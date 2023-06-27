package rw.pacis.ne.auth_boilerplate.services;

import rw.pacis.ne.auth_boilerplate.dtos.ProductQuantityDTO;

public interface IProductQuantityService {
    String registerProductQuantity(ProductQuantityDTO productQuantityDTO);
}
