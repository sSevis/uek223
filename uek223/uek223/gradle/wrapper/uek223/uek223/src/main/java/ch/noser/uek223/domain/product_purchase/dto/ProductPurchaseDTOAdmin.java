package ch.noser.uek223.domain.product_purchase.dto;

import ch.noser.uek223.domain.product.Product;
import ch.noser.uek223.domain.product.dto.ProductDTOAdmin;
import ch.noser.uek223.domain.purchase.dto.PurchaseDTOAdmin;

import java.util.UUID;

public class ProductPurchaseDTOAdmin {

    private UUID id;

    private PurchaseDTOAdmin purchase;

    private ProductDTOAdmin product;

    private int amount;

    public ProductPurchaseDTOAdmin(UUID id, PurchaseDTOAdmin purchase, ProductDTOAdmin product, int amount) {
        this.id = id;
        this.purchase = purchase;
        this.product = product;
        this.amount = amount;
    }

    public ProductPurchaseDTOAdmin() {
    }

    public UUID getId() {
        return id;
    }

    public ProductPurchaseDTOAdmin setId(UUID id) {
        this.id = id;
        return this;
    }

    public PurchaseDTOAdmin getPurchase() {
        return purchase;
    }

    public ProductPurchaseDTOAdmin setPurchase(PurchaseDTOAdmin purchase) {
        this.purchase = purchase;
        return this;
    }

    public ProductDTOAdmin getProduct() {
        return product;
    }

    public ProductPurchaseDTOAdmin setProduct(ProductDTOAdmin product) {
        this.product = product;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public ProductPurchaseDTOAdmin setAmount(int amount) {
        this.amount = amount;
        return this;
    }
}
