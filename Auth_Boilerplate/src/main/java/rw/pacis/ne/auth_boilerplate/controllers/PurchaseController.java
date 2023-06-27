package rw.pacis.ne.auth_boilerplate.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.pacis.ne.auth_boilerplate.models.Purchased;
import rw.pacis.ne.auth_boilerplate.services.PurchaseService;


@RestController
@RequestMapping("/api/v1/check-out")
public class PurchaseController {
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public Purchased createPurchase(@RequestBody Purchased purchased) {
        return purchaseService.createPurchase(purchased);
    }
}
