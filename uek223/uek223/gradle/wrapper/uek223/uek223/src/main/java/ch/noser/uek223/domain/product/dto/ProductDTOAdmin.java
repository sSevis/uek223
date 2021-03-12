package ch.noser.uek223.domain.product.dto;

import ch.noser.uek223.domain.product.Availability;
import ch.noser.uek223.domain.product_purchase.dto.ProductPurchaseDTOAdmin;
import ch.noser.uek223.domain.user.dto.UserDTOAdmin;

import java.util.Set;
import java.util.UUID;

public class ProductDTOAdmin {

    private UUID id;

    private String description;

    private float buyingPrice;

    private float sellingPrice;

    private Availability availability;

    private UserDTOAdmin supplier;

    public ProductDTOAdmin(UUID id, String description, float buyingPrice, float sellingPrice, Availability availability, UserDTOAdmin supplier) {
        this.id = id;
        this.description = description;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.availability = availability;
        this.supplier = supplier;
    }

    public ProductDTOAdmin() {
    }

    public UUID getId() {
        return id;
    }

    public ProductDTOAdmin setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductDTOAdmin setDescription(String description) {
        this.description = description;
        return this;
    }

    public float getBuyingPrice() {
        return buyingPrice;
    }

    public ProductDTOAdmin setBuyingPrice(float buyingPrice) {
        this.buyingPrice = buyingPrice;
        return this;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public ProductDTOAdmin setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
        return this;
    }

    public Availability getAvailability() {
        return availability;
    }

    public ProductDTOAdmin setAvailability(Availability availability) {
        this.availability = availability;
        return this;
    }

    public UserDTOAdmin getSupplier() {
        return supplier;
    }

    public ProductDTOAdmin setSupplier(UserDTOAdmin supplier) {
        this.supplier = supplier;
        return this;
    }
}
