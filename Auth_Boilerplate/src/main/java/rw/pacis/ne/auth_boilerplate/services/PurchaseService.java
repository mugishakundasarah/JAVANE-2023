package rw.pacis.ne.auth_boilerplate.services;

import rw.pacis.ne.auth_boilerplate.models.Purchased;

public interface PurchaseService {
    Purchased createPurchase(Purchased purchased);
}
