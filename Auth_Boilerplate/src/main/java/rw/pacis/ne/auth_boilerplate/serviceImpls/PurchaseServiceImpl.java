package rw.pacis.ne.auth_boilerplate.serviceImpls;

import org.springframework.stereotype.Service;
import rw.pacis.ne.auth_boilerplate.models.Purchased;
import rw.pacis.ne.auth_boilerplate.repositories.IPurchasedRepository;
import rw.pacis.ne.auth_boilerplate.services.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final IPurchasedRepository purchasedRepository;

    public PurchaseServiceImpl(IPurchasedRepository purchasedRepository) {
        this.purchasedRepository = purchasedRepository;
    }

    @Override
    public Purchased createPurchase(Purchased purchased) {
        return purchasedRepository.save(purchased);
    }
}
