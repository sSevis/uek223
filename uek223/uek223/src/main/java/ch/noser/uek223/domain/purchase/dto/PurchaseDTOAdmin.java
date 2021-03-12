package ch.noser.uek223.domain.purchase.dto;

import ch.noser.uek223.domain.product_purchase.dto.ProductPurchaseDTOAdmin;
import ch.noser.uek223.domain.user.dto.UserDTOAdmin;

import java.util.Set;
import java.util.UUID;

public class PurchaseDTOAdmin {

    private UUID id;

    private UserDTOAdmin costumer;

    public PurchaseDTOAdmin(UUID id, UserDTOAdmin costumer) {
        this.id = id;
        this.costumer = costumer;
    }

    public PurchaseDTOAdmin() {
    }

    public UUID getId() {
        return id;
    }

    public PurchaseDTOAdmin setId(UUID id) {
        this.id = id;
        return this;
    }

    public UserDTOAdmin getCostumer() {
        return costumer;
    }

    public PurchaseDTOAdmin setCostumer(UserDTOAdmin costumer) {
        this.costumer = costumer;
        return this;
    }
}
